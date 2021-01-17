package com.kodehive.mp2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.mp2.model.PelajaranModel;
import com.kodehive.mp2.repo.PelajaranRepo;

@Service
@Transactional
public class PelajaranService {
	
	@Autowired
	private PelajaranRepo pelajaranRepo;
	
	public Page<PelajaranModel> listPelajaran(Pageable pageable){
		return pelajaranRepo.findAll(pageable);
	}
	
	public PelajaranModel getId(String kode_pelajaran) {
		return this.pelajaranRepo.getId(kode_pelajaran);
	}
	
	public void tambah_data(PelajaranModel pelajaranModel) {
		pelajaranRepo.save(pelajaranModel);
	}
	
	public void save_edit(PelajaranModel pelajaranModel) {
		pelajaranRepo.save(pelajaranModel);
	}
	
	public PelajaranModel detail_data(String kode_pelajaran) {
		return pelajaranRepo.getId(kode_pelajaran);
	}
	
	public void delete_data(String kode_pelajaran) {
		pelajaranRepo.deleteById(kode_pelajaran);
	}
	
}
