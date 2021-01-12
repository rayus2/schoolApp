package com.kodehive.project_tech2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LaptopController {
	
	@RequestMapping("/laptop/list")
	public String listLaptop() {
		return "/laptop/list";
	}
}
