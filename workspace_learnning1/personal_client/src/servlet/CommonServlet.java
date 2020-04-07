package servlet;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class CommonServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CommonServlet(){
		super();
	}
	protected String getParameter(HttpServletRequest request,String paramname) throws UnsupportedEncodingException{
//		System.err.println(request.getMethod());
		if("GET".equals(request.getMethod())){
			String queryString = request.getQueryString();
			if(queryString!=null){
				String tempquery = queryString.substring(queryString.indexOf(paramname));
				tempquery = tempquery.substring(tempquery.indexOf("=")+1, tempquery.indexOf("&")==-1?tempquery.length():tempquery.indexOf("&") );
				return java.net.URLDecoder.decode(tempquery,"utf-8");
			}else{
				return null;
			}			
		}else if("POST".equals(request.getMethod())){
			request.setCharacterEncoding("UTF-8");
			return request.getParameter(paramname);
//			return new String(request.getParameter(paramname).getBytes("ISO-8859-1"),"utf-8");
		}else{
			return null;
		}

		
	}	
}
