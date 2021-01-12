package com.kodehive.mp2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.mp2.model.SiswaModel;

public interface SiswaRepo extends JpaRepository<SiswaModel, String>{
	
	@Query("SELECT S FROM SiswaModel S WHERE S.nim_siswa = ?1")
	SiswaModel getId(String nim_siswa);
	
}
