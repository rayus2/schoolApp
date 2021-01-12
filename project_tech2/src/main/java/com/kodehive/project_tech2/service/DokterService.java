package com.kodehive.project_tech2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodehive.project_tech2.model.DokterModel;
import com.kodehive.project_tech2.repository.DokterRep;

@Service
@Transactional
public class DokterService {

	@Autowired
	private DokterRep dokterRep;
	
	public DokterModel oneByName(String namaDokter) {
		return dokterRep.findByName(namaDokter);
	}
	
	public List<DokterModel> findByFirstName(String namaDokter) {
		return dokterRep.findByFirstName(namaDokter);
	}
	
	public List<DokterModel> findByLastName(String namaDokter) {
		return dokterRep.findByLastName(namaDokter);
	}
	
	public List<DokterModel> findBySalary(int salaryDokter) {
		return dokterRep.findBySalary(salaryDokter);
	}
	
	public List<DokterModel> findBySalary2(int salaryDokter) {
		return dokterRep.findBySalary2(salaryDokter);
	}
	
	public List<DokterModel> sortBySalaryDesc() {
		return dokterRep.sortBySalaryDesc();
	}
	
	public List<DokterModel> sortBySalaryAsc() {
		return dokterRep.sortBySalaryAsc();
	}
	
	
	
}
