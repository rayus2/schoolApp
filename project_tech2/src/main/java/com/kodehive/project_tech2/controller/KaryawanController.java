package com.kodehive.project_tech2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KaryawanController {

	@RequestMapping("/office/karyawan")
	public String Karyawan() {
		String html = "office/karyawan/Karyawan";
		return html;
	}
	
}
