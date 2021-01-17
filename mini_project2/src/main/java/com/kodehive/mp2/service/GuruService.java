package com.kodehive.mp2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.mp2.model.GuruModel;
import com.kodehive.mp2.repo.GuruRepository;

@Service
@Transactional
public class GuruService {
	

	@Autowired
	private GuruRepository guruRepository;

	public List<GuruModel> listGuru() {
		// TODO Auto-generated method stub
		return guruRepository.findAll();
	}

	public void tambah_data(GuruModel guruModel) {
		// TODO Auto-generated method stub
		guruRepository.save(guruModel);
	}

	public GuruModel getId(String nip_guru) {
		// TODO Auto-generated method stub
		return this.guruRepository.getId(nip_guru);
	}

	public void save_edit(GuruModel guruModel) {
		// TODO Auto-generated method stub
		guruRepository.save(guruModel);
	}

	public void delete_data(String nip_guru) {
		// TODO Auto-generated method stub
		guruRepository.deleteById(nip_guru);
	}

	public GuruModel detail_data(String nip_guru) {
		// TODO Auto-generated method stub
		return guruRepository.getId(nip_guru);
	}

	public Page<GuruModel> listGuru(Pageable pageable) {
		// TODO Auto-generated method stub
		return guruRepository.findAll(pageable);
	}
	
}
