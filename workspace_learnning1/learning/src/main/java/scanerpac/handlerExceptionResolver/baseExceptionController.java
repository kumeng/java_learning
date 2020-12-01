package scanerpac.handlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 方式3 使用@ExceptionHandler 注解 适合局部处理有”处理过程“的异常 其他Controller 继承次类即可
 * 
 * @author Administrator
 *
 */
public class baseExceptionController {
	@ExceptionHandler
	public String gotoerror(HttpServletRequest request, Exception ex) {
		request.setAttribute("ex", ex);
		return "error";
	}
}
