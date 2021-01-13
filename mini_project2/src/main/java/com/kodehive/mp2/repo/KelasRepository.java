package com.kodehive.mp2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.mp2.model.KelasModel;

public interface KelasRepository extends JpaRepository<KelasModel, String> {

	@Query("SELECT K FROM KelasModel K WHERE K.kode_kelas = ?1")
	KelasModel getId(String nip_guru);
	
}
