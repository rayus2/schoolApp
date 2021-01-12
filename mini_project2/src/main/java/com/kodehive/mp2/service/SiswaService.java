package com.kodehive.mp2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.mp2.model.SiswaModel;
import com.kodehive.mp2.repo.SiswaRepo;

@Service
@Transactional
public class SiswaService {

	@Autowired
	private SiswaRepo siswaRepo;
	
	public List<SiswaModel> listSiswa(){
		return siswaRepo.findAll();
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
