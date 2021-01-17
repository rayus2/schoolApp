package com.kodehive.mp2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.mp2.model.KelasModel;
import com.kodehive.mp2.repo.KelasRepository;

@Service
@Transactional
public class KelasService {

	@Autowired
	private KelasRepository kelasRepository;

	public List<KelasModel> listkelas() {
		// TODO Auto-generated method stub
		return kelasRepository.findAll();
	}

	public void tambah_data(KelasModel kelasModel) {
		// TODO Auto-generated method stub
		kelasRepository.save(kelasModel);
	}

	public KelasModel getId(String kelasID) {
		// TODO Auto-generated method stub
		return this.kelasRepository.getId(kelasID);
	}

	public void save_edit(KelasModel kelasModel) {
		// TODO Auto-generated method stub
		kelasRepository.save(kelasModel);
	}

	public void delete_data(String kode_kelas) {
		// TODO Auto-generated method stub
		kelasRepository.deleteById(kode_kelas);
	}

	public KelasModel detail_data(String kode_kelas) {
		// TODO Auto-generated method stub
		return kelasRepository.getId(kode_kelas);
	}

	public Page<KelasModel> listKelas(Pageable pageable) {
		// TODO Auto-generated method stub
		return kelasRepository.findAll(pageable);
	}

}
