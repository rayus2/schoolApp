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

import com.kodehive.mp2.model.KelasModel;
import com.kodehive.mp2.service.KelasService;

@RestController
public class KelasApiController {
	
	@Autowired
	private KelasService kelasService;
	
	@PostMapping("/kelas/api_post")
	public Map<String, Object> post_kelas(@RequestBody KelasModel kelasModel){
		
		this.kelasService.tambah_data(kelasModel);
		Map<String, Object> map = new HashMap<String, Object>();
	
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Ditambahkan");
		
		return map;
	}
	
	@GetMapping("/kelas/api_get")
	public Page<KelasModel> getAll_siswa(Pageable pageable){
		
		Page<KelasModel> kelasModelList = this.kelasService.listKelas(pageable);
		
		return kelasModelList;
	}
	
	@GetMapping("/kelas/api_getById")
	public KelasModel getById_siswa(@RequestParam String kode_kelas){
		
		KelasModel kelasModel = new KelasModel();
		kelasModel = this.kelasService.detail_data(kode_kelas);
		
		return kelasModel;
	}
	
	
	@PutMapping("/kelas/api_put")
	public Map<String, Object> put_kelas(@RequestBody KelasModel kelasModel){
		
		this.kelasService.save_edit(kelasModel);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Di Update");
		
		return map;
	}
	
	@DeleteMapping("/kelas/api_delete")
	public Map<String, Object> delete_kelas(@RequestParam String kode_kelas) {
		this.kelasService.delete_data(kode_kelas);
		
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Di Hapus");
		
		return map;
	}
}
