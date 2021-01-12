package com.kodehive.project_tech2.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodehive.project_tech2.model.PasienModel;
import com.kodehive.project_tech2.service.PasienService;

@RestController
public class PasienApiController {

	@Autowired
	private PasienService pasienService;
	
	@PostMapping("/post")
	public Map<String, Object> postApi(@RequestBody PasienModel pasienModel) {
		
		this.pasienService.addData(pasienModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil Masuk");
		
		
		return map;
	}
	
	@GetMapping("/getAll")
	public List<PasienModel> getApi() {
		
		List<PasienModel> pasienModelList = new ArrayList<PasienModel>();
		pasienModelList = this.pasienService.showData();
		
		return pasienModelList;
	}
	
	@PutMapping("/put")
	public Map<String, Object> putApi(@RequestBody PasienModel pasienModel) {
		
		this.pasienService.editData(pasienModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil di Update");
		
		
		return map;
	}
	
	@DeleteMapping("/delete")
	public Map<String, Object> deleteApi(@RequestParam String noPasien) {
		
		this.pasienService.deleteData(noPasien);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Berhasil di Hapus");
		
		return map;
	}

	@DeleteMapping("/delete/{noPasien}")
	public Map<String, Object> delete2Api(@PathVariable String noPasien) {
		
		this.pasienService.deleteData(noPasien);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data "+noPasien+" Berhasil di Hapus");
		
		return map;
	}
	
}
