package com.mxd.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mxd.pojo.po.User;
import com.mxd.service.IUserService;

@Controller
@RequestMapping("/mvc")
/*@RequestMapping("/mvc")
 * Ϊʲô�˴��Ӹ�mvc ��ҳ���ֻ��дaction=login�����ˣ���������
 * */
public class LoginDemo {
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping(value="/tologin",method=RequestMethod.POST)
	public String toLogin(){
		//����ʹ��forward��login�ᱨ405Get����Ĵ��󣿣�������
		return "forward:login";
	}
	@ResponseBody
	@RequestMapping(value="/json2",method=RequestMethod.GET)
	public Map<String, Object> json2(){
		Map<String , Object> map = new HashMap<>();
		map.put("name", "������");
		map.put("age", "18");
		return map;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpServletRequest request){
		User u = iUserService.findUser(user.getUsername(),user.getPassword());
		//System.out.println(user.getAddress().getProvince());
		if(u!=null){
			/*System.out.println(username);*/
			HttpSession session = request.getSession();
			session.setAttribute("user",u);
			return "loginSuccess";
		}
		return "loginFailed";
	}
	
	//�÷�ʽ�����֮ǰhttp://localhost:80/dd/user��id=222��ʽ
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public User getByIdTest(@PathVariable("userId") String id){
		System.out.println(id);
		return null;
	} 
	
	
	//�ϴ��ļ�����
	@RequestMapping(value="/toupload",method=RequestMethod.GET)
	public String toUpload(){
		return "upload";
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String saveFile(String name,MultipartFile file) throws IllegalStateException, IOException{
		System.out.println(name);
		if(!file.isEmpty()){
			file.transferTo(new File("D:/temp/"+file.getOriginalFilename()));
		}
		
		return "success";
	}
}
