package com.kodehive.mp2.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<KelasModel> getAll_kelas(){
		
		List<KelasModel> kelasModelList = new ArrayList<KelasModel>();
		kelasModelList = this.kelasService.listkelas();
		
		return kelasModelList;
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
