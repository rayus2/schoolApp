package com.kodehive.project_tech2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodehive.project_tech2.model.PasienModel;
import com.kodehive.project_tech2.repository.PasienRep;

@Service
@Transactional
public class PasienService {
	
	// Depedency Injection
	@Autowired
	private PasienRep pasienRep;
	
	public List<PasienModel> showData() {
		return pasienRep.findAll();
	}
	
	public void addData(PasienModel pasienModel) {
		pasienRep.save(pasienModel);
	}
	
	public PasienModel search(String keyName) {
		return this.pasienRep.getByName(keyName);
	}

	public PasienModel get(String noPasien) {
        return pasienRep.findById(noPasien).get();
    }
	
	public void editData(PasienModel pasienModel) {
        pasienRep.save(pasienModel);
    }
	
	public PasienModel getbyID(String noPasien) {
        return pasienRep.getById(noPasien);
    }
	
	public void deleteData(String noPasien) {
        pasienRep.deleteById(noPasien);
    }
	
}
