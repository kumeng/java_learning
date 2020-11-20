package scanerpac.controller;

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

import Constans.MyException1_1;
import Constans.MyException1_2;
import Constans.MyException2;
import scanerpac.entity.MsgModel;
import scanerpac.entity.PersonLoginModel;
import scanerpac.service.PersonLoginService;

/**
 * return "success";  默认返回视图名称，使用servlet转发
 * 
 * 要使用重定向的话
 * return "redirect:../error.jsp"; 
 * @author jiawen
 *
 */

@Controller
@RequestMapping("/controller/")
public class LoginController {
	
	@Resource
	private PersonLoginService  personLoginService;
	
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
		Integer dologin = personLoginService.dologin(name, pwd);
		if(true){
			//运行时异常runtimeException，编译不检查。
			throw new Constans.MyException1_1();
		}
		if(dologin.equals(1)){
			req.setAttribute("msg", "登陆成功");
			return "success";
		}else{
			req.setAttribute("ex", "登陆失败");
			return "error"; 
		}			
	}
	/**
	 * 获取页面参数2： 
	 * Spring 自动注入表单元素的值到 对应名称的参数，不同名称可用@RequestParam("form_inputName")指定
	 * @param req
	 * @return
	 */
	@RequestMapping("login2.do")
	public String dologin2(String name,@RequestParam("password")String pwd,HttpServletRequest req){
		Integer dologin = personLoginService.dologin(name, pwd);
		if(true){
			try {
				//非运行时异常，编译检查，需要try-catch处理，或者throws向上声明异常
				
				//向上声明才可被SPring捕获
				throw new Constans.MyException2("MyException2 非运行时异常，编译检查，需要try-catch处理，或者throws向上声明异常");
			} catch (MyException2 e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		if(dologin.equals(1)){
			req.setAttribute("msg", "登陆成功");
			return "success";
		}else{
			req.setAttribute("ex", "登陆失败");
			return "error"; 
		}
	}	
	
	/**
	 * 获取页面参数3： 
	 * 创建属性名称与页面表单元素名称一致的 bean(例：PersonLoginModel)。
	 * Spring自动将页面元素封装到 参数bean中
	 * @param req
	 * @return
	 */
	@RequestMapping("login3")
	public String dologin3(PersonLoginModel model ,HttpServletRequest req){
		Integer dologin = personLoginService.dologin(model.getName(), model.getPassword());
		if(true){
			//运行时异常runtimeException，编译不检查。
			throw new Constans.MyException1_3();
		}		
		if(dologin.equals(1)){
			req.setAttribute("msg", "登陆成功");
			return "success";
		}else{
			req.setAttribute("ex", "登陆失败");
			return "error"; 
		}		
	}	
	

	/**
	 * 向页面传值
	 * 
	 * ModelAndView对象
	 * ModelMap参数
	 * @ModelAttribute("model") 作用在参数
	 * 
	 * 三种方式均使用 HttpServletRequest  的Attribute方式向页面传递
	 */
	
	
	/**
	 * 使用ModelAndView 向页面传值
	 * @param name
	 * @param pwd
	 * @param req
	 * @return
	 */
	@RequestMapping("login4")
	public ModelAndView dologin4(String name,@RequestParam("password")String pwd,HttpServletRequest req)throws Constans.MyException2{
	
		Map<String,String> mapdata = new   HashMap<String,String>();
		
		Integer dologin = personLoginService.dologin(name, pwd);
		
		if(true){			
				//非运行时异常，编译检查，需要try-catch处理，或者throws向上声明异常
			throw new Constans.MyException2("MyException2 非运行时异常，编译检查，需要try-catch处理，或者throws向上声明异常");
		}
		if(dologin.equals(1)){
			
			mapdata.put("msg", "登陆成功");
			return new ModelAndView("success",mapdata);
		}else{
			mapdata.put("ex", "登陆失败");
			return new ModelAndView("error",mapdata);			
		}			
		
	}	
	/**
	 * 
	 * 使用ModelMap 参数 向页面传值
	 * @param name
	 * @param pwd
	 * @param req
	 * @param mapdata
	 * @return
	 */
	@RequestMapping("login5")
	public String dologin5(String name,@RequestParam("password")String pwd,HttpServletRequest req,ModelMap mapdata){		
		mapdata.put("msg", "如果");
		Integer dologin = personLoginService.dologin(name,pwd);
		if(dologin.equals(1)){
			mapdata.put("msg", "登陆成功");
			return "success";
		}else{
			mapdata.put("ex", "登陆失败");
			return "error"; 
		}			

	}	
	/**
	 * 使用@ModelAttribute("model")  注解到参数，将参数作为传递值
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping("login6")
	public String dologin6(@ModelAttribute("model")MsgModel msgmodel  ,PersonLoginModel model,HttpServletRequest req){
		Integer dologin = personLoginService.dologin(model.getName(), model.getPassword());
		if(dologin.equals(1)){
			msgmodel.setMsg("登陆成功");			
			return "success";
		}else{
			msgmodel.setEx("登陆失败");			
			return "error2";   //页面通过 model.ex 取值
		}			
	}	
	
	/**
	 * 重定向方式
	 * RedirectView  
	 * 
	 */
	
	@RequestMapping("login7")
	public ModelAndView dologin7(String name,@RequestParam("password")String pwd,HttpServletRequest req){
		req.getSession().setAttribute("msg", "sdfd认定法规定f");
		RedirectView  view  = new RedirectView("../success.jsp");
		Integer dologin = personLoginService.dologin(name, pwd);
		if(dologin.equals(1)){
			req.getSession().setAttribute("msg", "登陆成功");			
		}else{
			req.getSession().setAttribute("ex", "登陆失败");
//			req.setAttribute("ex", "登陆失败");
			view  = new RedirectView("../error.jsp");
		}			
		return new ModelAndView(view);
	}	
	/**
	 * 
	 * @param name
	 * @param pwd
	 * @param req
	 * @return
	 */
	@RequestMapping("login8")
	public String dologin8(String name,@RequestParam("password")String pwd,HttpServletRequest req){
		req.getSession().setAttribute("msg", "sdfd认定法规定f");
		Integer dologin = personLoginService.dologin(name, pwd);
		if(dologin.equals(1)){
			req.getSession().setAttribute("msg", "登陆成功");
			return "redirect:../success.jsp";
		}else{
			req.getSession().setAttribute("ex", "登陆失败");
			return "redirect:../error.jsp"; 
		}			
	}	
	
	
}
