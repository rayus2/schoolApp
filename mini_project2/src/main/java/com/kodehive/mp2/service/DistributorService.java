
package com.kodehive.mp2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.mp2.model.DistributorModel;
import com.kodehive.mp2.repo.DistributorRepository;



@Service
@Transactional
public class DistributorService { 


	@Autowired
	private DistributorRepository distriRepo;
	
	public Page<DistributorModel> listDistributor(Pageable pageable){
		return distriRepo.findAll(pageable);
	}
	
	public DistributorModel getId(String kd_distributor) {
		return this.distriRepo.getId(kd_distributor);
	}
	
	public void tambah_data(DistributorModel distributorModel) {
		distriRepo.save(distributorModel);
	}
	
	public void save_edit(DistributorModel distributorModel) {
		distriRepo.save(distributorModel);
	}
	
	public DistributorModel detail_data(String kd_distributor) {
		return distriRepo.getId(kd_distributor);
	}
	
	public void delete_data(String kd_distributor) {
		distriRepo.deleteById(kd_distributor);
	}
	

} 


