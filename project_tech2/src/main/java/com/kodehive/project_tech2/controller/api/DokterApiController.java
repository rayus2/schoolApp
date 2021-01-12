package com.kodehive.project_tech2.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodehive.project_tech2.model.DokterModel;
import com.kodehive.project_tech2.service.DokterService;

@RestController
public class DokterApiController {

	@Autowired
	private DokterService dokterService;
	
	@GetMapping("/getByName")
	public DokterModel getByName(@RequestParam String namaDokter) {
		
		DokterModel dm = new DokterModel();
		dm = this.dokterService.oneByName(namaDokter);
		
		return dm;
	}
	
	@GetMapping("/getByFirstName")
	public List<DokterModel> getByFirstName(@RequestParam String namaDokter) {
		
		List<DokterModel> dokterModelList = new ArrayList<DokterModel>();
		dokterModelList = this.dokterService.findByFirstName(namaDokter);
	
		return dokterModelList;
	}

	@GetMapping("/getByLastName")
	public List<DokterModel> getByLastName(@RequestParam String namaDokter) {
	
		List<DokterModel> dokterModelList = new ArrayList<DokterModel>();
		dokterModelList = this.dokterService.findByLastName(namaDokter);
	
		return dokterModelList;
	}
	
	@GetMapping("/getBySalary")
	public List<DokterModel> getBySalary(@RequestParam int salaryDokter) {
		
		List<DokterModel> dokterModelList = new ArrayList<DokterModel>();
		dokterModelList = this.dokterService.findBySalary(salaryDokter);
	
		return dokterModelList;
	}
	
	@GetMapping("/getBySalary2")
	public List<DokterModel> getBySalary2(@RequestParam int salaryDokter) {
		
		List<DokterModel> dokterModelList = new ArrayList<DokterModel>();
		dokterModelList = this.dokterService.findBySalary2(salaryDokter);
	
		return dokterModelList;
	}
	
	@GetMapping("/getBySalaryDesc")
	public List<DokterModel> getBySalaryDesc() {
		
		List<DokterModel> dokterModelList = new ArrayList<DokterModel>();
		dokterModelList = this.dokterService.sortBySalaryDesc();
	
		return dokterModelList;
	}
	
	@GetMapping("/getBySalaryAsc")
	public List<DokterModel> getBySalaryAsc() {
		
		List<DokterModel> dokterModelList = new ArrayList<DokterModel>();
		dokterModelList = this.dokterService.sortBySalaryAsc();
	
		return dokterModelList;
	}
}
