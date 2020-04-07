package servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
public class login extends CommonServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("name", URLEncoder.encode(super.getParameter(request,"name"),"utf-8"));
		session.setMaxInactiveInterval(120);
		
		ServletContext servletContext = session.getServletContext();
		if(servletContext.getAttribute("count")==null){
			servletContext.setAttribute("count", 1);
		}else{
			servletContext.setAttribute("count", 1+ (int)servletContext.getAttribute("count"));
		}
		StringBuffer sbr = new StringBuffer();
		sbr.append("<br/>");
		sbr.append(URLDecoder.decode(String.valueOf(session.getAttribute("name")),"utf-8"));
		sbr.append("<br/>");
		//session.invalidate();
		//sbr.append("session失效后"+session.getAttribute("name")==null);
		sbr.append(""+servletContext.getAttribute("count"));
		sbr.append("<br/>");
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath())
		.append("<br/>")
		.append(super.getParameter(request,"name"))
		.append("<br/>")
		.append(super.getParameter(request,"password"))
		.append(sbr.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
