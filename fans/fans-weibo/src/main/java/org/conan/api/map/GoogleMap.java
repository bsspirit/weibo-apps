package org.conan.api.map;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class GoogleMap {

    // http://maps.google.com/maps/geo?q=%E5%8C%97%E4%BA%AC%E5%8F%8C%E4%BA%95&output=json&sensor=false&key=bsspirit
    public static Map<String, String> address2point(String address) {
        Map<String, String> map = new HashMap<String, String>();
        HttpClient hc = new HttpClient();
        String url = "http://maps.google.com/maps/geo";
        GetMethod g = new GetMethod(url);
        NameValuePair[] data = { new NameValuePair("q", address), new NameValuePair("output", "json"), new NameValuePair("sensor", "false"), new NameValuePair("aisle", "229"), new NameValuePair("key", "AIzaSyAiFpFd85eMtfbvmVNEYuNds5TEF9FjIPI") };
        g.setQueryString(data);
        g.addRequestHeader("User-Agent","Mozilla/5.0 (Windows NT 5.1) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/19.0.1084.52 Safari/536.5");
        
        try {
            int code = hc.executeMethod(g);
            switch (code) {
            case 200:
                JSONObject json = (JSONObject) JSON.parse(g.getResponseBody());
                JSONArray placeArr = json.getJSONArray("Placemark");
                if(placeArr!=null){
                    JSONObject place = placeArr.getJSONObject(0);
                    JSONObject point = place.getJSONObject("Point");
                    JSONArray coordinates = point.getJSONArray("coordinates");
    
                    map.put("longitude", coordinates.getString(0));
                    map.put("latitude", coordinates.getString(1));
                }
                break;
            }
            Thread.sleep(1000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(address2point("镇江"));
    }
}
