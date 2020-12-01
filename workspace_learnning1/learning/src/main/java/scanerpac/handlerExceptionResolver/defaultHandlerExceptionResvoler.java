package scanerpac.handlerExceptionResolver;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import Constans.MyException1_1;
import Constans.MyException1_2;
import Constans.MyException1_3;
import Constans.MyException1_4;

/**
 * 异常处理2 适合全局处理有”处理过程“的异常
 * 
 * @author Administrator
 *
 */
public class defaultHandlerExceptionResvoler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		String msg = ex.getCause() == null ? ex.getMessage() : ex.getCause().getMessage();
		map.put("ex", msg);
		if (MyException1_1.class.isInstance(ex)) {
			return new ModelAndView("error1_1", map);
		} else if (MyException1_2.class.isInstance(ex)) {
			return new ModelAndView("error1_2", map);
		} else if (MyException1_3.class.isInstance(ex)) {
			return new ModelAndView("error1_3", map);
		} else if (MyException1_4.class.isInstance(ex)) {
			return new ModelAndView("error1_4", map);
		} else {
			return new ModelAndView("error", map);
		}
	}

}
