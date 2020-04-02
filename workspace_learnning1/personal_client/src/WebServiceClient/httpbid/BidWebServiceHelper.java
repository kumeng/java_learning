package WebServiceClient.httpbid;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
@SuppressWarnings("unchecked")
public class BidWebServiceHelper {
    
	private Logger LOG=Logger.getLogger(BidWebServiceHelper.class);
	public String getReturnResult(String url, String method, String paramJson) throws Exception {
		
		
	        String resutl = null;
	        String json = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" "
	        		+ " xmlns:web=\"http://WebService/\">\r\n" +
	                "   <soapenv:Header/>\r\n" +
	                "   <soapenv:Body>\r\n" +
	                "	<web:getName>\r\n" +
	                "	<arg0>"+paramJson+"</arg0>\r\n"+
	                "	</web:getName>\r\n"+	                	          	              
	                "   </soapenv:Body>\r\n" +
	                "</soapenv:Envelope>";
	        System.out.println(json);
	        LOG.info("请求体：【" + json + "】");
	        try {
	            PostMethod postMethod = new PostMethod(url);
	            // 然后把Soap请求数据添加到PostMethod中
	            byte[] b = json.getBytes("utf-8");
	            InputStream is = new ByteArrayInputStream(b,0,b.length);
	            RequestEntity re = new InputStreamRequestEntity(is,b.length,"application/text+xml; charset=utf-8");
	            postMethod.setRequestEntity(re);
	            //最后生成一个HttpClient对象，并发出postMethod请求
	            HttpClient httpClient = new HttpClient();
				httpClient.getHttpConnectionManager().getParams()
						.setConnectionTimeout(15000);
				httpClient.getHttpConnectionManager().getParams().setSoTimeout(15000);
				System.setProperty("sun.net.client.defaultConnectTimeout", String
						.valueOf(15000));// （单位：毫秒）
				System.setProperty("sun.net.client.defaultReadTimeout", String
						.valueOf(15000)); // （单位：毫秒）
	            int statusCode = httpClient.executeMethod(postMethod);
	            String soapResponseData = postMethod.getResponseBodyAsString();
	            if(statusCode == 200){
	            	LOG.info("调用成功！");
	                soapResponseData = postMethod.getResponseBodyAsString();
	                //解析返回参数
	                resutl = resultToXml(soapResponseData);
	                LOG.info("返回参数：【" + resutl + "】");
	            }else{
	                System.out.println("调用失败！错误码："+statusCode);
	                LOG.info("webservice请求失败："+soapResponseData);
	                throw new Exception("webservice请求失败: " + soapResponseData);
	            }
	        } catch (Exception e) {
	        	 LOG.info(e);
				if(e instanceof java.net.ConnectException)
					throw new java.net.ConnectException("webservice请求失败：服务无法连接!");
				else
					throw new Exception("webservice请求失败：" + e);
	        }
	        return resutl;
	    }

	    private static String resultToXml(String xml) throws Exception {

	        String X_RETURN_STATUS = "return";

	        return X_RETURN_STATUS;
	    }

    public static void main(String[] args) throws Exception {
    	Map map= new HashMap();
    	map.put("a", "15");
    	String str = JSON.toJSONString(map);
    	System.out.println(str);
//    	String res =  new BidWebServiceHelper().getReturnResult("http://192.168.1.35:8089/shjedi/services/webService?wsdl", "EBS_USERS_CUR_WL2LD",str );
    	String res =  new BidWebServiceHelper().getReturnResult("http://localhost:9001/Service/HelloService", "getName",str );
    	System.out.println("result="+res);
    }
}
