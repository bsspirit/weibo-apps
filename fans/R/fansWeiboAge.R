rm(list=ls())

library(RMySQL) 

conn <- dbConnect(dbDriver("MySQL"), dbname = "fans", username="root", password="mysql")## 打开一个MySQL数据库的连接
fansWeiboAge <- dbGetQuery(conn, paste("SELECT name,DATEDIFF(now(),created_at) as age FROM t_user order by age desc"))
dbDisconnect(conn)#关闭连接

count=c(length(which(fansWeiboAge$age<=100)),
        length(which(fansWeiboAge$age<=200 & fansWeiboAge$age>100)),
        length(which(fansWeiboAge$age<=300 & fansWeiboAge$age>200)),
        length(which(fansWeiboAge$age<=400 & fansWeiboAge$age>300)),
        length(which(fansWeiboAge$age<=500 & fansWeiboAge$age>400)),
        length(which(fansWeiboAge$age<=600 & fansWeiboAge$age>500)),
        length(which(fansWeiboAge$age<=700 & fansWeiboAge$age>600)),
        length(which(fansWeiboAge$age<=800 & fansWeiboAge$age>700)),
        length(which(fansWeiboAge$age<=900 & fansWeiboAge$age>800)),
        length(which(fansWeiboAge$age<=1000 & fansWeiboAge$age>900)),
        length(which(fansWeiboAge$age>1000))
)
percent=round(count/length(fansWeiboAge$age)*100)
labels=c("<100","100-200","200-300","300-400","400-500","500-600","600-700","700-800","800-900","900-1000",">1000")

#ages = data.frame(labels,count)
#pie(count,labels=labels,clockwise=TRUE,radius=1,border="white",main="我的微博粉丝年龄比例")
barplot(count,xlab="年龄(天)",ylab="粉丝数",ylim=c(0,1.5*max(count)),horiz=FALSE)
axis(1,1:length(count),labels)

#print(fansWeiboAge)
#print(count)

