package com.kodehive.mp2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.mp2.model.PelajaranModel;

public interface PelajaranRepo extends JpaRepository<PelajaranModel, String>{

	@Query("SELECT P FROM PelajaranModel P WHERE P.kode_pelajaran = ?1")
	PelajaranModel getId(String kode_pelajaran);

	
}
