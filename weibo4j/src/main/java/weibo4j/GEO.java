package weibo4j;

import weibo4j.http.HttpClient;
import weibo4j.model.PostParameter;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class GEO {
    public static HttpClient client = new HttpClient();
    
    /*----------------------------位置信息接口----------------------------------------*/
    /**
     * 根据实际地址返回地理信息坐标
     * 
     * @param address
     *            地址
     * @return geos
     * @throws WeiboException
     *             when Weibo service or network is unavailable
     * @version weibo4j-V2 1.0.1
     * @see <a href="http://http://open.weibo.com/wiki/2/location/geo/address_to_geo">geos</a>
     * @since JDK 1.5
     */
    public Object addressToGeo(String address) throws WeiboException {
        return Weibo.client.get(WeiboConfig.getValue("baseURL") + "location/geo/address_to_geo.json", new PostParameter[] { new PostParameter("address", address) }).asJSONObject();
    }
    
}
