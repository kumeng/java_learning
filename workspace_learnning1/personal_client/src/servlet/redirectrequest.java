package servlet;

import java.io.IOException;
import java.net.CookieStore;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class testRequest
 *
 */
public class redirectrequest   extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public redirectrequest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		Object attribute = request.getAttribute("ceid");
		//重定向
		HttpSession session = request.getSession();
		String id = session.getId();		
		session.setAttribute("sessionid", id);
		Cookie cookie = new Cookie("name",URLEncoder.encode("中文需要转成ANSI码","utf-8"));
		//当然读取cookie中文值时也需要转码
		cookie.setMaxAge(-1);//<0保存到客户端内存浏览器关闭则删除  =0，表示立即删除，>0表示到期删除，删除之前是保存在硬盘上的
		cookie.setPath("/");//设置触发发送此cookie的访问路径.访问此路径的子路径也会发送 
		//这里设置全项目发送
		response.addCookie(cookie);//使用reponse返回给客户端
		//cookie 只能写字符串，大小大概4kb左右，数量也有限制，客户端可以禁用。也可以查看保存在硬盘的cookie，所以敏感数据需要加密
		//cookie 不能删除，如果需要，添加同名cookie，设置maxage(0)替换原cookie达到删除目的，修改cookie也需要已此方法替换
		
		response.sendRedirect("/test");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
