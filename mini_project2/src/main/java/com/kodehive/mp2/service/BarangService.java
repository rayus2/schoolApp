package com.kodehive.mp2.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public List<BarangModel> listBarang() {
		return barangRepository.findAll();
	}
	
	public void tambah_data(BarangModel barangModel) {
		barangRepository.save(barangModel);
	
	}
	
	public BarangModel getId(String kdBarang) {
		// TODO Auto-generated method stub
		return this.barangRepository.getId(kdBarang);
	}
	
	public void save_edit(BarangModel barangModel) {
		// TODO Auto-generated method stub
		barangRepository.save(barangModel);
	}

	public void delete_data(String kdBarang) {
		// TODO Auto-generated method stub
		barangRepository.deleteById(kdBarang);
	}

	public BarangModel detail_data(String kdBarang) {
		// TODO Auto-generated method stub
		return barangRepository.getId(kdBarang);
	}

	public Page<BarangModel> listBarang(Pageable pageable) {
		// TODO Auto-generated method stub
		return barangRepository.findAll(pageable);
	}


} 
