package com.kodehive.project_tech2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.project_tech2.model.LaptopModel;

// T, ID => Table, dataType PrimaryKey
public interface LaptopRep extends JpaRepository<LaptopModel, Integer> {
	
	@Query("SELECT L FROM LaptopModel L")
	List<LaptopModel> readData();
	
	@Query("SELECT L FROM LaptopModel L WHERE L.merk LIKE '?1%' ")
	List<LaptopModel> searchData(String merk);
	
	@Query("SELECT L FROM LaptopModel L WHERE L.id=?1")
	LaptopModel searchDetail(int id);
	
	@Query("SELECT L FROM LaptopModel L ORDER BY L.id DESC")
	List<LaptopModel> sortDesc();
	
}
