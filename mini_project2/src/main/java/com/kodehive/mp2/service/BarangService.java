package com.kodehive.mp2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.mp2.model.BarangModel;
import com.kodehive.mp2.repo.BarangRepository;

@Service
@Transactional
public class BarangService { 

	// Depencies Injection mempermudah metode 
	@Autowired
	private BarangRepository barangRepository;
	
	public List<BarangModel> temukan() {
		return barangRepository.findAll();
	}
	
	public void barangSave(BarangModel barangModel) {
		barangRepository.save(barangModel);
	
	}
	
	public BarangModel barangUpdate(BarangModel barangModel) {
		 return barangRepository.save(barangModel);
	}

	public void barangHapus(BarangModel kdBarang) {
		// TODO Auto-generated method stub
		barangRepository.delete(kdBarang);
	}
	
	public BarangModel barangIDBaca(String idBarang) {
		return barangRepository.noBarang(idBarang);
	}
	

} 
