package com.mxd.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.mxd.pojo.po.User;
import com.mxd.service.IUserService;

@Controller
/*@RequestMapping("/mvc")
 * 为什么此处加个mvc 表单页面就跳转不过来？？？？？
 * */
public class LoginDemo {
	@Autowired
	private IUserService iUserService;
	
	@RequestMapping("/tologin")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpServletRequest request){
		User u = iUserService.findUser(user.getUsername(),user.getPassword());
		if(u!=null){
			/*System.out.println(username);*/
			HttpSession session = request.getSession();
			session.setAttribute("user",u);
			return "loginSuccess";
		}
		return "loginFailed";
	}
	
	//该方式替代了之前http://localhost:80/dd/user？id=222方式
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public User getByIdTest(@PathVariable("userId") String id){
		System.out.println(id);
		return null;
	} 
}
