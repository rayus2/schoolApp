package com.kodehive.project_tech2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.project_tech2.model.PasienModel;

public interface PasienRep extends JpaRepository<PasienModel, String> {

	@Query("SELECT P FROM PasienModel P WHERE P.namaPasien LIKE %?1%")
	PasienModel getByName(String keyName);
	
	@Query("SELECT P FROM PasienModel P WHERE P.noPasien=?1")
	PasienModel getById(String noPasien);
	
}
