package com.kodehive.project_tech2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.project_tech2.model.DokterModel;

public interface DokterRep extends JpaRepository<DokterModel, String>{

	@Query("SELECT D FROM DokterModel D WHERE namaDokter=?1")
	DokterModel findByName(String namaDokter);
	
	@Query("SELECT D FROM DokterModel D WHERE namaDokter LIKE ?1%")
	List<DokterModel> findByFirstName(String namaDokter);
	
	@Query("SELECT D FROM DokterModel D WHERE namaDokter LIKE %?1")
	List<DokterModel> findByLastName(String namaDokter);
	
	@Query("SELECT D FROM DokterModel D WHERE salaryDokter = ?1")
	List<DokterModel> findBySalary(int salaryDokter);
	
	@Query("SELECT D FROM DokterModel D WHERE salaryDokter > ?1")
	List<DokterModel> findBySalary2(int salaryDokter);
	
	@Query("SELECT D FROM DokterModel D ORDER BY salaryDokter DESC")
	List<DokterModel> sortBySalaryDesc();
	
	@Query("SELECT D FROM DokterModel D ORDER BY salaryDokter ASC")
	List<DokterModel> sortBySalaryAsc();
	
	
}
