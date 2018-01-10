package com.mxd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class TestDemo01 {
	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
}
