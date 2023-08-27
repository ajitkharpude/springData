package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontrollermanytoone {
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	BatchRepo batchRepo;

	@RequestMapping("savebody")
	private Student save(@RequestBody Student student) {

		student.batch.id = batchRepo.batchid(student.batch.name);
		student.batch.triner = batchRepo.batchtranner(student.batch.name);

		return studentRepo.save(student);
		// TODO Auto-generated method stub

	}

// create---------------------------------------------------
	@RequestMapping("Addbatchbody")
	private Batch savebatch(@RequestBody Batch batch) {
		return batchRepo.save(batch);
	}

	@RequestMapping("abc")
	public String abcd() {
		// TODO Auto-generated method stub

		Batch batch = new Batch(2, "july", "Palak mam");
		batchRepo.save(batch);
		Student s1 = new Student(7, "somu dada", 41, batch);
		Student s2 = new Student(8, "gomu dada", 40, batch);
		Student s3 = new Student(9, "pomu dada", 39, batch);
		Student s4 = new Student(10, "romu dada", 38, batch);
		Student s5 = new Student(11, "somya dada", 37, batch);
		Student s6 = new Student(12, "gomya dada", 36, batch);
		studentRepo.save(s1);
		studentRepo.save(s2);
		studentRepo.save(s3);
		studentRepo.save(s4);
		studentRepo.save(s5);
		studentRepo.save(s6);
		return "done";
	}

	@RequestMapping("savepath/{name}/{marks}/{batchid}")
	private Student savepath(@PathVariable String name, @PathVariable int marks, @PathVariable int batchid,
			Student student) {

		student.name = name;
		student.marks = marks;

		student.batch = batchRepo.findById(batchid).get();

		return studentRepo.save(student);
		// TODO Auto-generated method stub

	}

	// read----------------------------------------
	@RequestMapping("showstudent")
	public List<Student> showdata() {
		return studentRepo.findAll();
		// TODO Auto-generated method stub

	}

	@RequestMapping("showbatch")
	public List<Batch> showdataba() {
		return batchRepo.findAll();
		// TODO Auto-generated method stub

	}

	@RequestMapping("readBatch/{id}")
	public Batch readbatchid(@PathVariable int id) {
		return batchRepo.findById(id).get();
		// TODO Auto-generated method stub
	}

//update--------------------------------------------------------
	@RequestMapping("updatestudentdata/{id}")
	public Student updatedata(@RequestBody Student student, @PathVariable int id) {
		Batch batch = batchRepo.findById(id).get();
		student.batch = batch;
		return studentRepo.save(student);
	}

	// delte-------------------------------------------------------------
	@RequestMapping("delteStudent{id}")
	public String adddatapostma(@PathVariable int id) {
		studentRepo.deleteById(id);
		return "done";

	}
}
