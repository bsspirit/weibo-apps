package org.conan.fans.util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.conan.api.map.GoogleMap;
import org.conan.api.map.SinaProvinces;
import org.conan.fans.weibo.model.ProvincesDTO;

/**
 * 对省市(地理信息)进行出始化
 * 
 * @author Administrator
 * 
 */
final public class ProvinceUtil {

    public static void initProvince() {
        List<ProvincesDTO> list = SinaProvinces.provinces();
        initProvincesGeo(list);
    }

    private static void initProvincesGeo(List<ProvincesDTO> list) {
        // 确定坐标
        Map<String, String> map = new HashMap<String, String>();
        
        boolean skip =  true;
        for (ProvincesDTO dto : list) {
            if(dto.getName().equals("苏州")){
                skip=false;
            }
            
            if(skip){
                continue;
            }
            
            String pname = null;
            if (dto.getCid() != null) {
                pname = dto.getName();
                map.putAll(GoogleMap.address2point(pname));
                dto.setLongitude(map.get("longitude"));
                dto.setLatitude(map.get("latitude"));
            } else {
                map.putAll(GoogleMap.address2point(pname + dto.getName()));
                dto.setLongitude(map.get("longitude"));
                dto.setLatitude(map.get("latitude"));
            }
            outputSQL(transfer2SQL(dto));
            map.clear();
        }
    }

    private static String transfer2SQL(ProvincesDTO dto) {
        String template = "INSERT INTO t_provinces (name,pid,cid,longitude,latitude) VALUES (''{0}'',{1},{2},''{3}'',''{4}'');\n";
        String insert = MessageFormat.format(template, dto.getName(), String.valueOf(dto.getPid()), String.valueOf((dto.getCid() == null ? 1000 : dto.getCid())), dto.getLongitude(), dto.getLatitude());
        System.out.println(insert);
        return insert;
    }

    private static void outputSQL(String content) {
        String file = "provinces.sql";
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
