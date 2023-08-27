package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	BatchRepo batchRepo;
	
	@RequestMapping("save")
	public Batch addtioninbody(@RequestBody Batch batch) {
		studentRepo.saveAll(batch.student);
		return batchRepo.save(batch);

	}
	
}
