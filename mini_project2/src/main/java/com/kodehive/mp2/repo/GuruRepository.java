package com.kodehive.mp2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.mp2.model.GuruModel;


public interface GuruRepository extends JpaRepository<GuruModel, String> {

	@Query("SELECT G FROM GuruModel G WHERE G.nip_guru = ?1")
	GuruModel getId(String nip_guru);
}
