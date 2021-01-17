package com.kodehive.mp2.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodehive.mp2.model.GuruModel;
import com.kodehive.mp2.service.GuruService;


@RestController
public class GuruApiController {

	@Autowired
	private GuruService guruService;
	
	@PostMapping("/guru/api_post")
	public Map<String, Object> post_guru(@RequestBody GuruModel guruModel){
		
		this.guruService.tambah_data(guruModel);
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Ditambahkan");
		
		return map;
	}
	
	
	
	@GetMapping("/guru/api_get")
	public Page<GuruModel> getAll_guru(Pageable pageable){
		
		Page<GuruModel> guruModelList = this.guruService.listGuru(pageable);
		
		return guruModelList;
	}
	
	@GetMapping("/guru/api_getById")
	public GuruModel getById_siswa(@RequestParam String nip_guru){
		
		GuruModel guruModel = new GuruModel();
		guruModel = this.guruService.detail_data(nip_guru);
		
		return guruModel;
	}
	
	
	@PutMapping("/guru/api_put")
	public Map<String, Object> put_guru(@RequestBody GuruModel guruModel){
		
		this.guruService.save_edit(guruModel);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Di Update");
		
		return map;
	}
	
	@DeleteMapping("/guru/api_delete")
	public Map<String, Object> delete_guru(@RequestParam String nip_guru) {
		this.guruService.delete_data(nip_guru);
		
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Di Hapus");
		
		return map;
	}
	
}
