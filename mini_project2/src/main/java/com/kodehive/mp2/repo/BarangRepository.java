package com.kodehive.mp2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.mp2.model.BarangModel;

public interface BarangRepository extends JpaRepository<BarangModel, String>{ // kasarnya SELESAI

	
	@Query("SELECT B FROM BarangModel B WHERE B.kdBarang = ?1")
	BarangModel noBarang(String kdBarang);
	
	
}
