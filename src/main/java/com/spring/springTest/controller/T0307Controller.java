package com.spring.springTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/0307")
public class T0307Controller {
	
	// @RequestMapping("/0307/test1")
	@RequestMapping("/test1")
	public String test1Get() {
		return "0307/test01";
	}

	
}
