package com.spring.springTest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springTest.vo.TestVo;

@Controller
@RequestMapping("/0306")
public class T0306Controller {
	
	//@RequestMapping("/0306/test1")
	//@RequestMapping("/test1")
	//@GetMapping("/test1")
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1Get() {
		return "0306/test01";
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2Get(Model model) {
		model.addAttribute("message", "안녕하세요");		
		return "0306/test02";
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3Get(HttpServletRequest request) {
		request.setAttribute("message", "반갑습니다.");
		return "0306/test03";
	}
	
	@RequestMapping(value = "/test4", method = RequestMethod.GET)
	public String test4Get(HttpServletRequest request) {
		String name = "홍길동";
		int age = 20;
		String gender = "남자";
		String address = "서울";
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("gender", gender);
		request.setAttribute("address", address);
		
		return "0306/test04";
	}
	
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String test5Get() {
		return "0306/test05";
	}
	
	@RequestMapping(value = "/test5", method = RequestMethod.POST)
	public String test5Post(HttpServletRequest request) {
		String name = request.getParameter("name")==null ? "" : request.getParameter("name");
		int age = request.getParameter("age")==null ? 0 : Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender")==null ? "" : request.getParameter("gender");
		String address = request.getParameter("address")==null ? "" : request.getParameter("address");
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("gender", gender);
		request.setAttribute("address", address);
		
		return "0306/test05Ok";
	}
	
	@RequestMapping(value = "/test6", method = RequestMethod.GET)
	public String test6Get() {
		return "0306/test06";
	}
	/*
	@RequestMapping(value = "/test6", method = RequestMethod.POST)
	public String test6Post(HttpServletRequest request, TestVo vo) {
		String name = request.getParameter("name")==null ? "" : request.getParameter("name");
		int age = request.getParameter("age")==null ? 0 : Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender")==null ? "" : request.getParameter("gender");
		String address = request.getParameter("address")==null ? "" : request.getParameter("address");
		
		//TestVo vo = new TestVo();
		vo.setName(name);
		vo.setAge(age);
		vo.setGender(gender);
		vo.setAddress(address);
		
		request.setAttribute("vo", vo);
		
		return "0306/test06Ok";
	}
	
	@RequestMapping(value = "/test6", method = RequestMethod.POST)
	public String test6Post(HttpServletRequest request, TestVo vo,
			String name,	int age, String gender, String address) {
		name = request.getParameter("name")==null ? "" : request.getParameter("name");
		age = request.getParameter("age")==null ? 0 : Integer.parseInt(request.getParameter("age"));
		gender = request.getParameter("gender")==null ? "" : request.getParameter("gender");
		address = request.getParameter("address")==null ? "" : request.getParameter("address");
		
		//TestVo vo = new TestVo();
		vo.setName(name);
		vo.setAge(age);
		vo.setGender(gender);
		vo.setAddress(address);
		
		request.setAttribute("vo", vo);
		
		return "0306/test06Ok";
	}
	
	@RequestMapping(value = "/test6", method = RequestMethod.POST)
	public String test6Post(HttpServletRequest request, TestVo vo,
			String name,	int age, String gender, String address) {
		
		//TestVo vo = new TestVo();
		vo.setName(name);
		vo.setAge(age);
		vo.setGender(gender);
		vo.setAddress(address);
		
		request.setAttribute("vo", vo);
		
		return "0306/test06Ok";
	}
	
	@RequestMapping(value = "/test6", method = RequestMethod.POST)
	public String test6Post(HttpServletRequest request, TestVo vo) {
		request.setAttribute("vo", vo);
		
		return "0306/test06Ok";
	}
	*/
	@RequestMapping(value = "/test6", method = RequestMethod.POST)
	public String test6Post(Model model, TestVo vo) {
		model.addAttribute("vo", vo);
		return "0306/test06Ok";

	}
	@RequestMapping(value = "/test7", method = RequestMethod.GET )
	public String test7Get() {
		return "0306/test07";
	}	
	@RequestMapping(value = "/test7", method = RequestMethod.POST)
	public String test7Post(Model model, TestVo vo,
		//String name,
		@RequestParam("name") String irum,
//		@RequestParam(name="mid", defaultValue = "없음", required = true) String mid,
//		@RequestParam(name="mid", required = false) String mid,
		@RequestParam(name="mid", defaultValue = "없음", required = false) String mid,
		int age, 
		String gender, 
		String address,
		@RequestParam(name="job", defaultValue = "기타") String job
		) {
		//String irum = name;
		vo.setName(irum);
		vo.setMid(mid);
		vo.setAge(age);
		vo.setGender(gender);
		vo.setAddress(address);
		vo.setJob(job);
		model.addAttribute("vo", vo);
		return "0306/test07Ok";
	}
	
	@RequestMapping(value = "/test8", method = RequestMethod.GET )
	public String test8Get() {
		return "0306/test08";
	}	
	@RequestMapping(value = "/{name}/test8Ok/{age}", method = RequestMethod.GET )
	public String test8OkGet(Model model, TestVo vo, 
			@PathVariable String name,
			@PathVariable int age
			) {
		model.addAttribute("vo", vo);
		return "0306/test08Ok";
	}	
	
	@RequestMapping(value = "/test9", method = RequestMethod.GET )
	public String test9Get() {
		return "0306/test09";
	}	
	@RequestMapping(value = "/test9", method = RequestMethod.POST )
	public ModelAndView test9Post(TestVo vo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.setViewName("0306/test09Ok");
		return mv;
	}
	
	@RequestMapping(value = "/test10", method = RequestMethod.GET )
	public String test10Get() {
		return "0306/test10";
	}
	
	@RequestMapping(value = "/test10Ok/{sabun}", method = RequestMethod.GET )
	public String test10OkGet(@PathVariable String sabun, Model model) {
		String busea = "";
		
		if(sabun.substring(0, 1).toLowerCase().equals("i")) busea = "인사과";
		else if(sabun.substring(0, 1).toLowerCase().equals("c")) busea = "총무과";
		else if(sabun.substring(0, 1).toLowerCase().equals("s")) busea = "생산과";
		else busea = "기타";
		
		sabun = sabun.substring(1); //1234(1번지부터 다 들어감)
		model.addAttribute("busea",busea);
		model.addAttribute("sabun",sabun);
		
		return "0306/test10Ok";
	}
	
	@RequestMapping(value = "/test11", method = RequestMethod.GET )
	public String test11Get() {
		return "0306/test11";
	}
	@RequestMapping(value = "/test11", method = RequestMethod.POST )
	public String test11Post(Model model, TestVo vo, HttpServletRequest request) {
		String busea = "";
		if(vo.getSabun().substring(0, 1).toLowerCase().equals("i")) busea = "인사과";
		else if(vo.getSabun().substring(0, 1).toLowerCase().equals("c")) busea = "총무과";
		else if(vo.getSabun().substring(0, 1).toLowerCase().equals("s")) busea = "생산과";
		else busea = "기타";
		
	
		vo.setSabun(vo.getSabun().substring(1));
		vo.setBusea(busea);
		
		
		model.addAttribute("vo", vo);
		
		model.addAttribute("message", "회원에 가입되셨습니다.");
		model.addAttribute("url", request.getContextPath()+"/0306/test11Ok?busea="+vo.getBusea()+"&sabun="+vo.getSabun()+"&name="+vo.getName());
		
		return "include/message";
	}
	
	@RequestMapping(value = "/test11Ok", method = RequestMethod.GET )
	public String test11OkGet(Model model, TestVo vo) {
		model.addAttribute("vo", vo);
		return "0306/test11Ok";
	}
	
	@RequestMapping(value = "/test12", method = RequestMethod.GET )
	public String test12Get() {
		
		return "0306/test12";
	}
	@RequestMapping(value = "/test12", method = RequestMethod.POST )
	public String test12Post(Model model, TestVo vo) {
		String busea = "";
		if(vo.getSabun().substring(0, 1).toLowerCase().equals("i")) busea = "인사과";
		else if(vo.getSabun().substring(0, 1).toLowerCase().equals("c")) busea = "총무과";
		else if(vo.getSabun().substring(0, 1).toLowerCase().equals("s")) busea = "생산과";
		else busea = "기타";
		
		vo.setSabun(vo.getSabun().substring(1));
		vo.setBusea(busea);
		
		model.addAttribute("vo", vo);
		return "0306/test12";
	}
}
