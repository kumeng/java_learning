package scanerpac.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/controller/")
public class FileUploadController {
	@RequestMapping("fileupload")
	public String dologin1(@RequestParam(value="file2",required=false)MultipartFile file,HttpServletRequest req,ModelMap modelmap){
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		modelmap.put("msg", "上传成功 "+file.getName()+IOUtils.LINE_SEPARATOR+file.getOriginalFilename());
		return "success";
	}	
	@RequestMapping("fileupload2")
	public String dologin2(HttpServletRequest req,ModelMap modelmap){
//		MultipartFile partfile = req.getParameter("file");
//		modelmap.put("msg", "上传成功 "+partfile.getName()+IOUtils.LINE_SEPARATOR+partfile.getOriginalFilename());
		modelmap.put("msg", "上传成功 ");
		return "success";
	}		
}


