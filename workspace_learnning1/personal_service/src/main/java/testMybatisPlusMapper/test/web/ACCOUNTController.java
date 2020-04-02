package testMybatisPlusMapper.test.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import testMybatisPlusMapper.test.entity.ACCOUNT;
import testMybatisPlusMapper.test.service.IACCOUNTService;

/**
 * <p>
 * ${table.comment} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2018-11-29
 */
@Controller
@RequestMapping("/test/aCCOUNT")
public class ACCOUNTController {
	
	@Resource
	private IACCOUNTService  aCCOUNTService;
	
	private ACCOUNT  a = createAccount();
	private ACCOUNT  b = createAccount();
	
	private Wrapper<ACCOUNT>  wrapper=new EntityWrapper<ACCOUNT>(b);
	
	@RequestMapping("/addone")
	public String addone(ModelMap model){	
		aCCOUNTService.insert(a);
		model.put("msg", "插入成功");
		return "index";
	}
	@RequestMapping("/updateOne")
	public String updateone(ModelMap model){		
		a.setPWD("12345");
		aCCOUNTService.update(a, wrapper);
		model.put("msg", "修改成功");
		return "index";
	}
	@RequestMapping("/selectALl")
	public String selectALL(ModelMap model){
		a.setPWD(null);
		wrapper=new EntityWrapper<ACCOUNT>(a);
		wrapper.ge("ID", 2l).orNew(" ID < {0} ", 2l);
		List<ACCOUNT> selectList = aCCOUNTService.selectList(wrapper);
		model.put("msg", "查询成功");
		model.put("list", selectList);
		return "index";
	}
	@RequestMapping("/DELALl")
	public String dellALL(ModelMap model){
		aCCOUNTService.delete(wrapper);
		model.put("msg", "删除全部成功");
		return "index";
	}	
	
	
	private ACCOUNT   createAccount(){
		ACCOUNT  a = new ACCOUNT();
		a.setID(1l);
		a.setLOGINNAME("Lisinopril");
		a.setPWD("1234");
		return a;
	}
	
}
