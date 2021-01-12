package com.kodehive.project_tech2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodehive.project_tech2.model.PasienModel;
import com.kodehive.project_tech2.repository.PasienRep;

@Service
@Transactional
public class LaptopService {
	
	@Autowired
	private PasienRep pasienRep;

	public List<PasienModel> showData() {
		return pasienRep.findAll();
	}

}
