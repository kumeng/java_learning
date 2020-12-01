package scanerpac.handlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class defaultInterceptor implements HandlerInterceptor {

	/**
	 * 处理器执行前被调用
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("defaultInterceptor.preHandle");
		return true;
	}

	/**
	 * 处理器执行后、视图解析前被调用
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("defaultInterceptor.postHandle");
	}

	/**
	 * 整个处理请求完毕被调用 必须preHandle为TRUE 才执行
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("defaultInterceptor.afterCompletion");
	}

}
