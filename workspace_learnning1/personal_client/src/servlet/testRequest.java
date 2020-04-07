package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class testRequest
 *
 */
public class testRequest   extends CommonServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public testRequest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 StringBuffer sbb = new StringBuffer();
		 
			HttpSession session = request.getSession();
			String id = session.getId();		
			 sbb.append(id+",getAttribute(sessionid):"+session.getAttribute("sessionid"));			
			 sbb.append("<br/>");			
		 
		 
		 Enumeration attributeNames = request.getAttributeNames();
		 while(attributeNames.hasMoreElements()){
			 String name = attributeNames.nextElement().toString();
			 sbb.append(name+":"+request.getAttribute(name)+"<br/>");
		 }
		 String attribute = super.getParameter(request,"ceid");

		 sbb.append("传递过来的ceid:"+attribute+"<br/>");
		 sbb.append("<br/>");
		 sbb.append("request.getAuthType():"+request.getAuthType()+"<br/>");
		 sbb.append("request.getCharacterEncoding():"+request.getCharacterEncoding()+"<br/>");
		 sbb.append("request.getContentType():"+request.getContentType()+"<br/>");
		 String headName = null;
		Enumeration   e = request.getHeaderNames();
		while(e.hasMoreElements()){
			headName = e.nextElement().toString();
			sbb.append(headName+":");
			sbb.append(request.getHeader(headName));
			sbb.append("<br/>");
		}
		sbb.append("请求方式getMethod："+request.getMethod()+"<br/>");
		sbb.append("请求的getProtocol："+request.getProtocol()+"<br/>");
		sbb.append("请求的getRequestURI："+request.getRequestURI()+"<br/>");
		sbb.append("请求的getRequestURL："+request.getRequestURL()+"<br/>");
		sbb.append("请求的servlet路径："+request.getServletPath()+"<br/>");
		sbb.append("请求的ContextPath："+request.getContextPath()+"<br/>");
		response.setContentType("text/html; charset=utf-8");
		SimpleDateFormat  sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
		sbb.append("当前时间:"+sd.format(new Date())+"<br/>");
		sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		sbb.append("当前时间:"+sd.format(new Date())+"<br/>");
		
		response.getWriter().append(sbb.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	


}
