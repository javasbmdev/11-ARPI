package com.mp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.entities.CitizenApplicationEntity;
@Repository
public interface CitizensApplicationRepository extends JpaRepository<CitizenApplicationEntity, Serializable>{
	
}
