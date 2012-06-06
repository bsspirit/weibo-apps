package org.conan.api.map;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.conan.fans.weibo.model.ProvincesDTO;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

final public class SinaProvinces {
    
    // http://api.t.sina.com.cn/provinces.xml
    public static List<ProvincesDTO> provinces() {
        List<ProvincesDTO> list = new ArrayList<ProvincesDTO>();
        HttpClient hc = new HttpClient();
        String url = "http://api.t.sina.com.cn/provinces.json";
        GetMethod g = new GetMethod(url);
        g.setRequestHeader("Content-Type", "text/javascript;charset=utf-8");
        
        try {
            int code = hc.executeMethod(g);
            switch (code) {
            case 200:
                JSONObject obj = (JSONObject) JSON.parse(g.getResponseBody());
                ListIterator<Object> provinces = obj.getJSONArray("provinces").listIterator();
                while (provinces.hasNext()) {
                    JSONObject p = (JSONObject) provinces.next();
                    int pid = p.getIntValue("id");
                    String pname = p.getString("name");
                    list.add(new ProvincesDTO(pname, pid, null, null, null));// 省
                    
                    ListIterator<Object> citys = p.getJSONArray("citys").listIterator();
                    while (citys.hasNext()) {
                        JSONObject c = (JSONObject) citys.next();
                        Iterator<Map.Entry<String,Object>> iter = c.entrySet().iterator();
                        while (iter.hasNext()) {
                            Map.Entry<String,Object> k = iter.next();
                            list.add(new ProvincesDTO(k.getValue().toString(), pid, Integer.parseInt(k.getKey()), null, null));// 市
                        }
                    }
                }
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        provinces();
    }
    
}
