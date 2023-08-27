package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BatchRepo extends JpaRepository<Batch, Integer> {

	@Query(value = "select id from batch where name=?1", nativeQuery = true)
	int batchid(String name);

	@Query(value = "select triner from batch where name=?1", nativeQuery = true)
	String batchtranner(String name);

	

	

}
