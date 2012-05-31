package org.conan.base.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class MyDate {
    
    final public static String FORMAT_DATE = "yyyy-MM-dd";
    final public static String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
    final public static String FORMAT_DATE_INT = "yyyyMMdd";
    
    public static String dateString(Date date) {
        return dateString(date, FORMAT_DATE);
    }
    
    public static String dateString(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }
    
    public static Timestamp dateTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }
    
    public static Date timestampDate(Timestamp time){
        return new Date(time.getTime());
    }
    
    /**
     * 昨天0点，今天0点
     */
    public static Date[] dateMorningStrings() {
        Date morning = todayMorning();
        Date prefDay = prevDate(morning, 1);
        return new Date[] { prefDay, morning };
    }
    
    public static int dateInt(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATE_INT);
        return Integer.parseInt(df.format(date));
    }
    
    public static Date date(String date) {
        return date(date, FORMAT_DATE);
    }
    
    public static Date date(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Date dateMorning(Date date) {
        return date(dateString(date, FORMAT_DATE), FORMAT_DATE);
    }
    
    public static Date todayMorning() {
        return dateMorning(getNow());
    }
    
    public static Date nextDate(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, num);
        return cal.getTime();
    }
    
    public static Date prevDate(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, num * (-1));
        return cal.getTime();
    }
    
    public static int diffDays(String date1, String date2) {
        return diffDays(date(date1, "yyyyMMdd"), date(date2, "yyyyMMdd"));
    }
    
    public static int diffDays(Date date1, Date date2) {
        return (int) diffHours(date1, date2) / 24;
    }
    
    public static int diffHours(String date1, String date2) {
        return diffHours(date(date1, "yyyyMMdd"), date(date2, "yyyyMMdd"));
    }
    
    public static int diffHours(Date date1, Date date2) {
        return (int) diffSecs(date1, date2) / (60 * 60);
    }
    
    public static int diffSecs(String date1, String date2) {
        return diffSecs(date(date1, "yyyyMMdd"), date(date2, "yyyyMMdd"));
    }
    
    public static int diffSecs(Date date1, Date date2) {
        Date s1 = date1;
        Date s2 = date2;
        
        if (date1.after(date2)) {
            s1 = date2;
            s2 = date1;
        }
        long time = s2.getTime() - s1.getTime();
        return (int) (time / 1000);
    }
    
    public static boolean compare(Date d1, Date d2) {
        return d1.getTime() >= d2.getTime() ? true : false;
    }
    
    public static Date getNow() {
        return new Date();
    }
    
    
    // /**
    // * 格式: 20101212
    // *
    // * @param day
    // * @return
    // */
    // public static String dayString(Date day) {
    // SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
    // return df.format(day);
    // }
    
    // /**
    // * 格式: 20101212
    // *
    // * @param day
    // * @return
    // */
    // public static int dayInt(Date day) {
    // return Integer.parseInt(dayString(day));
    // }
    
    // /**
    // * 格式: 20101212171700
    // *
    // * @param day
    // * @return
    // */
    // public static String datetimeString(Date day) {
    // SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
    // return df.format(day);
    // }
    //
    // /**
    // * 格式: 2010-12-12 10:10:10
    // *
    // * @param day
    // * @return
    // */
    // public static String datetimeString2(Date day) {
    // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // return df.format(day);
    // }
    
    // /**
    // * 格式: 2010.12.12 10:10:10
    // *
    // * @param day
    // * @return
    // */
    // public static String datetimeString3(Date day) {
    // SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    // return df.format(day);
    // }
    //
    // /**
    // * 格式：12.12 10:10
    // *
    // * @param day
    // * @return
    // */
    // public static String datetimeString4(Date day) {
    // SimpleDateFormat df = new SimpleDateFormat("MM.dd HH:mm");
    // return df.format(day);
    // }
    
    // /**
    // * 格式：12月12日 10:10
    // *
    // * @param day
    // * @return
    // */
    // public static String datetimeString5(Date day) {
    // SimpleDateFormat df = new SimpleDateFormat("MM月dd日 HH:mm");
    // return df.format(day);
    // }
    
    // /**
    // * 今日0点时间
    // *
    // * @param day
    // * @return
    // */
    // public static Date dayMorning(Date day) {
    // SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
    // Date morning = null;
    // try {
    // morning = df.parse(df.format(day));
    // } catch (ParseException e) {
    // }
    // return morning;
    // }
    
    // /**
    // * 之前的X天
    // *
    // * @param day
    // * @param xday
    // * @return
    // */
    // public static Date beforeDay(Date day, int xday) {
    // Calendar calendar = Calendar.getInstance();
    // int today = calendar.get(Calendar.DAY_OF_YEAR);
    // calendar.set(Calendar.DAY_OF_YEAR, today - xday);
    // return calendar.getTime();
    // }
    //
    // /**
    // * 之后的X天
    // *
    // * @param day
    // * @param xday
    // * @return
    // */
    // public static Date nextDay(Date day, int xday) {
    // Calendar calendar = Calendar.getInstance();
    // int today = calendar.get(Calendar.DAY_OF_YEAR);
    // calendar.set(Calendar.DAY_OF_YEAR, today + xday);
    // return calendar.getTime();
    // }
    //
    // /**
    // * 转型Date -> Timestamp
    // *
    // * @param date
    // * @return
    // */
    // public static Timestamp date2Timestamp(Date date) {
    // return new Timestamp(date.getTime());
    // }
    
    /**
     * 比较d1,d2大小
     * 
     * @param d1
     * @param d2
     * @return
     */
    
    // /**
    // * 转型到数据库Date格式
    // *
    // * @param date
    // * @return
    // * @throws ParseException
    // */
    // public static Date setDBDate(String date) throws ParseException {
    // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // return df.parse(date);
    // }
    
    // /**
    // * Date数据库格式转型到String
    // *
    // * @param date
    // * @return
    // * @throws ParseException
    // */
    // public static String getDBDate(Date date) {
    // return datetimeString2(date);
    // }
    //
    // /**
    // * 转型到数据库Timestamp格式
    // *
    // * @param date
    // * @return
    // * @throws ParseException
    // */
    // public static Timestamp setDBTimestamp(String date) throws ParseException {
    // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // return date2Timestamp(df.parse(date));
    // }
    //
    // /**
    // * Timestamp数据库格式转型到String
    // *
    // * @param time
    // * @return
    // * @throws ParseException
    // */
    // public static String getDBTimestamp(Timestamp time) {
    // return datetimeString2(time);
    // }
    
    //
    // public static void main(String[] args) throws ParseException {
    // System.out.println(setDBTimestamp("2010-12-12 00:12:12"));
    // System.out.println(getDBTimestamp(date2Timestamp(new Date())));
    // System.out.println(setDBDate("2010-12-12 00:12:12"));
    // System.out.println(getDBDate(new Date()));
    //
    // System.out.println(datetimeString2(beforeDay(new Date(), 7)));
    // System.out.println(datetimeString2(nextDay(new Date(), 7)));
    // }
}
