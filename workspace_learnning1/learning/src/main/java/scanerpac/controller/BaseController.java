package scanerpac.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

import Constans.MyException1_1;
import Constans.MyException1_2;
import Constans.MyException1_3;
import Constans.MyException1_4;

public class BaseController {

	public BaseController() {

	}

	/**
	 * <!-- 方式3 使用@ExceptionHandler 注解 适合局部处理有”处理过程“的异常-->
	 */
	@ExceptionHandler
	public String goException(HttpServletRequest req, Exception ex) {
		String msg = ex.getCause() == null ? ex.getMessage() : ex.getCause().getMessage();
		req.setAttribute("ex", msg);
		if (MyException1_1.class.isInstance(ex)) {
			return "error1_1";
		} else if (MyException1_2.class.isInstance(ex)) {
			return "error1_2";
		} else if (MyException1_3.class.isInstance(ex)) {
			return "error1_3";
		} else if (MyException1_4.class.isInstance(ex)) {
			return "error1_4";
		} else {
			return "error";
		}
	}
}
