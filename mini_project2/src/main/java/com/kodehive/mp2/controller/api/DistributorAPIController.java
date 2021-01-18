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

import com.kodehive.mp2.model.DistributorModel;
import com.kodehive.mp2.service.DistributorService;

@RestController
public class DistributorAPIController {
	
	@Autowired
	private DistributorService distriService;
	
	@PostMapping("/distributor/api_post")
	public Map<String, Object> post_distributor(@RequestBody DistributorModel distributorModel) {  //K untuk Key, V untuk Value
		
		this.distriService.tambah_data(distributorModel);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("success", Boolean.TRUE);
		map.put("pesan","data distributor berhasil ditambahkan");
		
		return map;
	}  
	
	@GetMapping("/distributor/api_get")
	public Page<DistributorModel> getAll_distributor(Pageable pageable){
		
		 Page<DistributorModel> distributorModelList = this.distriService.listDistributor(pageable);
		
		return distributorModelList;
	}
	
	@GetMapping("/distributor/api_getById")
	public DistributorModel getById_distributor(@RequestParam String kdDistributor){
		
		DistributorModel distributorModel = new DistributorModel();
		distributorModel = this.distriService.detail_data(kdDistributor);
		
		return distributorModel;
	}
	
	@PutMapping("/distributor/api_put")
	public Map<String, Object> put_distributor(@RequestBody DistributorModel distributorModel){
		
		this.distriService.save_edit(distributorModel);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("success", Boolean.TRUE);
		map.put("pesan", "data distributor berhasil di update");
		
		return map;
	}
	
	@DeleteMapping("/distributor/api_delete")
	public Map<String, Object> delete_distributor(@RequestParam String kdDistributor) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		this.distriService.delete_data(kdDistributor);
		map.put("success", Boolean.TRUE);
		map.put("pesan", "data distributor berhasil di hapus");
		
		return map;
	}

}