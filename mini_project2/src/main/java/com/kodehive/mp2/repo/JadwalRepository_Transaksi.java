package com.kodehive.mp2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.mp2.model.JadwalModel_Transaksi;


public interface JadwalRepository_Transaksi extends JpaRepository<JadwalModel_Transaksi, String>{
	 
		@Query("SELECT J FROM JadwalModel_Transaksi J WHERE J.id = ?1")
		JadwalModel_Transaksi getId(String id);
}
