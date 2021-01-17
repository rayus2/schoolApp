package com.kodehive.mp2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.mp2.model.SiswaModel;
import com.kodehive.mp2.repo.SiswaRepo;

@Service
@Transactional
public class SiswaService {

	@Autowired
	private SiswaRepo siswaRepo;
	
	public Page<SiswaModel> listSiswa(Pageable pageable){
		return siswaRepo.findAll(pageable);
	}
	
	public SiswaModel getId(String nim_siswa) {
		return this.siswaRepo.getId(nim_siswa);
	}
	
	public void tambah_data(SiswaModel siswaModel) {
		siswaRepo.save(siswaModel);
	}
	
	public void save_edit(SiswaModel siswaModel) {
		siswaRepo.save(siswaModel);
	}
	
	public SiswaModel detail_data(String nim_siswa) {
		return siswaRepo.getId(nim_siswa);
	}
	
	public void delete_data(String nim_siswa) {
		siswaRepo.deleteById(nim_siswa);
	}
	
}
