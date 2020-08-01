package HttpCilent;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class HttpUtils {
	public static String doMapParamPost(String url,String sessionId,Map<String,Object> map){
		String result = null;		
		try {
			URL urls  = new URL(url);
			HttpURLConnection openConnection = (HttpURLConnection)urls.openConnection();
			openConnection.setRequestMethod("POST");
	        //3.2设置content-type
//			openConnection.setRequestProperty("content-type", "text/xml;charset=utf-8");
			openConnection.setRequestProperty("content-type", "application/json;charset=utf-8");
			openConnection.setRequestProperty("Cookie",sessionId);

	        //3.3设置输入输出，默认没有读写权限
			openConnection.setDoOutput(true);
			openConnection.setDoInput(true);	
	        
	        //第四步，准备soap数据，发送请求
			OutputStream outputStream = null;
			if(!map.isEmpty()){
		        outputStream = openConnection.getOutputStream();
		        String jsonString = JSON.toJSONString(map);
		        outputStream.write(jsonString.getBytes("utf-8"));				
			}
	        
	        //第五步，接受服务器响应
	        int responseCode = openConnection.getResponseCode();
	        
	        if(200==responseCode){//表示响应成功
	        	InputStream inputStream = openConnection.getInputStream();
	        	
	        	InputStreamReader ir = new InputStreamReader(inputStream,"UTF-8");  
	        	char[] cr = new char[1];
	        	StringBuffer sf = new StringBuffer();
	        	while(ir.read(cr)!=-1){
	        		sf.append(cr);
	        	}
	        	result=sf.toString();
	        }
	        if(outputStream!=null){
	        	outputStream.close();	
	        }	                
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static String doJSONStringPost(String url,String sessionId,String paramJson){
		String result = null;		
		try {
			URL urls  = new URL(url);
			HttpURLConnection openConnection = (HttpURLConnection)urls.openConnection();
			openConnection.setRequestMethod("POST");
	        //3.2设置content-type
//			openConnection.setRequestProperty("content-type", "text/xml;charset=utf-8");
			openConnection.setRequestProperty("content-type", "application/json;charset=utf-8");
			openConnection.setRequestProperty("Cookie",sessionId);

	        //3.3设置输入输出，默认没有读写权限
			openConnection.setDoOutput(true);
			openConnection.setDoInput(true);	
	        
	        //第四步，准备soap数据，发送请求
			OutputStream outputStream = null;
			if(paramJson!=null){
		        outputStream = openConnection.getOutputStream();
		        outputStream.write(paramJson.getBytes("utf-8"));				
			}
	        
	        //第五步，接受服务器响应
	        int responseCode = openConnection.getResponseCode();
	        
	        if(200==responseCode){//表示响应成功
	        	InputStream inputStream = openConnection.getInputStream();
	        	InputStreamReader ir = new InputStreamReader(inputStream,"UTF-8");  
	        	char[] cr = new char[1];
	        	StringBuffer sf = new StringBuffer();
	        	while(ir.read(cr)!=-1){
	        		sf.append(cr);
	        	}
	        	result=sf.toString();
	        }
	        if(outputStream!=null){
	        	outputStream.close();	
	        }	                
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}	
}
