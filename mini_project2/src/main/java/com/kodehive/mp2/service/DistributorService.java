package com.kodehive.mp2.service;

import java.util.List;




import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.projectb2.model.DistributorModel;
import com.project.projectb2.repository.DistributorRepository;


@Service
@Transactional
public class DistributorService { 

	// Depencies Injection mempermudah metode 
	@Autowired
	private DistributorRepository distriRepository;
	
	public List<DistributorModel> temukan2() {
		return distriRepository.findAll();
	}
	
	public void distriSave(DistributorModel distributorModel) {
		distriRepository.save(distributorModel);
	}
	
	public DistributorModel distriUpdate(DistributorModel distributorModel) {
		 return distriRepository.save(distributorModel);
	}

	public void distriHapus(String kdDistributor) {
		distriRepository.deleteById(kdDistributor);
	}
	
	public DistributorModel distriID(String idDistributor) {
		return distriRepository.noDistributor(idDistributor);
	}
	

} 
