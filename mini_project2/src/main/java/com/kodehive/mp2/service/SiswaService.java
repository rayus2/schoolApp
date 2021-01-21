package com.kodehive.mp2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.mp2.model.NilaiModel;
import com.kodehive.mp2.model.SiswaModel;
import com.kodehive.mp2.model.SppModel;
import com.kodehive.mp2.repo.NilaiRepository;
import com.kodehive.mp2.repo.SiswaRepo;
import com.kodehive.mp2.repo.SppRepo;

@Service
@Transactional
public class SiswaService {

	@Autowired
	private SiswaRepo siswaRepo;
	
	@Autowired
	private SppRepo sppRepo;
	
	@Autowired
	private NilaiRepository nilaiRepository;
	
	public Page<SiswaModel> listSiswa(Pageable pageable){
		return siswaRepo.findAll(pageable);
	}
	
	public List<SiswaModel> siswaTransaksi(){
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
	
	// save spp
	public void save_spp(SppModel sppModel) {
		sppRepo.save(sppModel);
	}
	
	// save nilai
	public void save_nilai(NilaiModel nilaiModel) {
		nilaiRepository.save(nilaiModel);
	}
	
}
