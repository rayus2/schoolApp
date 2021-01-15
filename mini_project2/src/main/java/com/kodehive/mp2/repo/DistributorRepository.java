package com.kodehive.mp2.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.projectb2.model.DistributorModel;

public interface DistributorRepository extends JpaRepository<DistributorRepository, String>{ 

	
	@Query("SELECT D FROM DistributorModel D WHERE D.kdDistributor = ?1")
	DistributorModel noDistributor(String kdDistributor);


	
	
	
}
