package com.portfolio.yoonho.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {
	@RequestMapping("/")
	public String main() throws Exception {
		return "/main";
	}
	
	@RequestMapping("/apiDocs")
	public String apiDocs() throws Exception {
		return "redirect:/swagger-ui.html";
	}
}
