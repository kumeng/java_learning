package  scanerpac.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import  scanerpac.service.PersonLoginService;

@Controller
@RequestMapping("/controller/")
public class RegisterController extends BaseController {
	@Resource
	private PersonLoginService  personLoginService;
	
	@RequestMapping("register")
	public String doRegister(String name,@RequestParam("password")String pwd,HttpServletRequest req,ModelMap mapdata){		
		mapdata.put("ex", "测试异常处理");
		boolean dologin = false; 
//		dologin = personLoginService.Register(name,pwd);

		if(true){
			return goException(req, new Constans.MyException1_4());
		}
		
		
		if(dologin){
			mapdata.put("msg", "注册成功");
			return "success";
		}else{
			mapdata.put("ex", "注册失败");
			return "error"; 
		}			

	}		
}
