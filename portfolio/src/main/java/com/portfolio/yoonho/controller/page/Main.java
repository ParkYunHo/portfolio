package com.portfolio.yoonho.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
	@RequestMapping("/")
	public String main() throws Exception {
		return "/main";
	}
	
	@RequestMapping("/navbar")
	public String navbar() throws Exception {
		return "/contents/navbar";
	}
	
	@RequestMapping("/sidebar")
	public String sidebar() throws Exception {
		return "/contents/sidebar";
	}
	
	@RequestMapping("/footer")
	public String footer() throws Exception {
		return "/contents/footer";
	}
	
	@RequestMapping("/content")
	public String content() throws Exception {
		return "/contents/content";
	}
	
	
	
	@RequestMapping("/dashboard")
	public String dashboard() throws Exception {
		return "/index";
	}
	
	@RequestMapping("/apiDocs")
	public String apiDocs() throws Exception {
		return "redirect:/swagger-ui.html";
	}
}
