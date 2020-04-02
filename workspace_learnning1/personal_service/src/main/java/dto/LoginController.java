package dto;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/controller/")
public class LoginController {
	
	/**
	 * 获取页面参数一： 
	 *  使用HttpServletRequest 获取
	 * @param req
	 * @return
	 */
	@RequestMapping("login1")
	public String dologin1(HttpServletRequest req){
		String name = req.getParameter("name");
		String pwd = req.getParameter("password");
		return "success";		
	}
}
