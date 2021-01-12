package com.kodehive.project_tech2.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.project_tech2.model.FirstModel;

@Controller
public class FirstPage {
	
//	@RequestMapping("/home")
//	public String Home() {
//		String html = "Home"; 
//		return html;
//	}
//	
//	@RequestMapping("/laptop")
//	public String Laptop() {
//		String html = "Laptop"; 
//		return html;
//	}
//	
//	@RequestMapping("/mahasiswa")
//	public String Mahasiswa() {
//		String html = "Mahasiswa"; 
//		return html;
//	}
//	
//	@RequestMapping("/menu")
//	public String Menu() {
//		String html = "Menu"; 
//		return html;
//	}

	@RequestMapping("/modal")
	public String modal() {
		return "/modal";
	}
	
	@RequestMapping("/task_fe")
	public String task_fe() {
		return "/task_FE";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}
	
	@RequestMapping(value="/login/submit")
	public String logo(HttpServletRequest request, Model model) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		FirstModel firstModel = new FirstModel();
		firstModel.setUsername(username);
		firstModel.setPassword(password);
		
		model.addAttribute("firstModel", firstModel);
		
		return "dashboard";
	}
	
}
