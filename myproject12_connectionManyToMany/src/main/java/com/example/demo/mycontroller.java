package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mycontroller {
	@Autowired
	BatchRepo batchRepo;
	@Autowired
	StudentRepo studentRepo;

//create------------------------------------
	@RequestMapping("save")
	public boolean savea() {
		Student s1 = new Student(0, "somu", 45);
		Student s2 = new Student(0, "gomu", 44);
		studentRepo.save(s1);
		studentRepo.save(s2);
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);

		Batch batch = new Batch(0, "june", "akshay", list);
		Batch batch2 = new Batch(0, "july", "palak", list);
		batchRepo.save(batch);
		batchRepo.save(batch2);

		return true;
	}

	@RequestMapping("save/{bid}")
	public boolean savbody(@RequestBody Student student, @PathVariable int bid) {
		studentRepo.save(student);
		Batch batch = batchRepo.findById(bid).get();
		List<Student> list1 = batch.student;
		list1.add(student);
		Batch b1 = new Batch(batch.id, batch.name, batch.triner, list1);
		batchRepo.save(b1);

		return true;
	}

	@RequestMapping("savenewbatchandstudentbatch")
	public Batch savbody(@RequestBody Batch batch) {
		if (batch.student == null) {
			batchRepo.save(batch);
		} else {
			studentRepo.saveAll(batch.student);
			batchRepo.save(batch);
		}
		return batch;
	}

	// read-------------------------
	@RequestMapping("printAllstudents")
	public List<Batch> batchofstudent() {

		return batchRepo.findAll();

	}

	@RequestMapping("getstudents/{id}")
	public Batch getofstudentbatch(@PathVariable int id) {

		return batchRepo.findById(id).get();

	}

//update----------------------------------------------------
	@RequestMapping("updatestudentdata/{id}")
	public Student updatedataname(@RequestBody Student student) {

		return studentRepo.save(student);
	}

	@RequestMapping("updatebatchdata/{id}")
	public String updatebatchname(@RequestBody Batch batch) {
		batchRepo.save(batch);

		return "done";
	}

	@RequestMapping("updatestudentdata/{stid}/{id}/{updateid}")
	public String updatedata(@PathVariable int stid, @PathVariable int id, @PathVariable int updateid) {
		Batch batch = batchRepo.findById(id).get();
		Batch batch1 = batchRepo.findById(updateid).get();
		List<Student> list = batch.student;
		List<Student> list2 = batch1.student;

		for (int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			if (s.id == stid) {
				list2.add(s);

			}
		}
		Batch b3 = new Batch(updateid, batch1.name, batch1.triner, list2);
		batchRepo.save(b3);
		return "done";
	}

//delete--------------------------------------------------
	@RequestMapping("deletebybatch{id}")
	public String deleteofstudentbatch(@PathVariable int id) {

		batchRepo.deleteById(id);
		;
		return "true";

	}

	@RequestMapping("deletebystudent{bid}/{sid}")
	public String deleteofstudent(@PathVariable int bid, @PathVariable int sid) {

		Batch batch = batchRepo.findById(bid).get();
		List<Student> list1 = batch.student;
		for (int i = 0; i < list1.size(); i++) {
			Student s = list1.get(i);
			if (s.id == sid) {

				list1.remove(s);
			}
		}
		Batch b3 = new Batch(batch.id, batch.name, batch.triner, list1);
		batchRepo.save(b3);

		return "true";

	}

}
