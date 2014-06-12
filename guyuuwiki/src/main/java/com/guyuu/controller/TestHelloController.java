package com.guyuu.controller;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestHelloController {
	
	@RequestMapping("/test")
	public String testHtml() {
			return "test";
		}

}
