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

import com.kodehive.mp2.model.SiswaModel;
import com.kodehive.mp2.service.SiswaService;

@RestController
public class SiswaApiController {

	@Autowired
	private SiswaService siswaService;
	
	@PostMapping("/siswa/api_post")
	public Map<String, Object> post_siswa(@RequestBody SiswaModel siswaModel){
		
		this.siswaService.tambah_data(siswaModel);
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Ditambahkan");
		
		return map;
	}
	
	@GetMapping("/siswa/api_get")
	public Page<SiswaModel> getAll_siswa(Pageable pageable){
		
		Page<SiswaModel> siswaModelList = this.siswaService.listSiswa(pageable);
		
		return siswaModelList;
	}
	
	@GetMapping("/siswa/api_getById")
	public SiswaModel getById_siswa(@RequestParam String nim_siswa){
		
		SiswaModel siswaModel = new SiswaModel();
		siswaModel = this.siswaService.detail_data(nim_siswa);
		
		return siswaModel;
	}
	
	@PutMapping("/siswa/api_put")
	public Map<String, Object> put_siswa(@RequestBody SiswaModel siswaModel){
		
		this.siswaService.save_edit(siswaModel);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Di Update");
		
		return map;
	}
	
	@DeleteMapping("/siswa/api_delete")
	public Map<String, Object> delete_siswa(@RequestParam String nim_siswa) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		this.siswaService.delete_data(nim_siswa);
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Di Hapus");
		
		return map;
	}
	
}
