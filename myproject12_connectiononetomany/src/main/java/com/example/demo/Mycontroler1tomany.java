package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroler1tomany {
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	BatchRepo batchRepo;

//create-----------------------------------------
	@RequestMapping("add")
	public boolean add() {
		Student s1 = new Student(0, "somu dada", 45);
		Student s2 = new Student(0, "gomu dada", 44);
		Student s3 = new Student(0, "somya dada", 40);
		Student s4 = new Student(0, "gomya dada", 45);
		studentRepo.save(s1);
		studentRepo.save(s2);
		studentRepo.save(s3);
		studentRepo.save(s4);
		List<Student> list1 = new ArrayList<>();
		list1.add(s1);
		list1.add(s2);
		List<Student> list2 = new ArrayList<>();
		list2.add(s3);
		list2.add(s4);
		try {
			Batch batch = new Batch(0, "july", "akshay", list1);
			Batch batch2 = new Batch(0, "june", "akshay", list2);
			batchRepo.save(batch);
			batchRepo.save(batch2);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@RequestMapping("save")
	public boolean save(@RequestBody Student student) {

		studentRepo.save(student);
		List<Student> list1 = new ArrayList<>();
		list1.add(student);
		Batch batch = new Batch(0, "advance", "akshay", list1);
		batchRepo.save(batch);
		return true;
	}

	@RequestMapping("saveUsinglist")
	public Batch saveusinglist(@RequestBody Batch batch) {
		
		studentRepo.saveAll(batch.student);
			
			return batchRepo.save(batch);

		

		}

	// read---------------------------------------------
	@RequestMapping("readBatch/{id}")
	public Batch readBatch(@PathVariable int id) {

		return batchRepo.findById(id).get();
	}

	@RequestMapping("readBatchdata")
	public List<Batch> readBatchdata() {

		return batchRepo.findAll();
	}

	// update-------------------------------------------
	@RequestMapping("updateStudentNamefromBatch/{batchid}/{studentid}/{newname}")
	public String updatenamefrombatch(@PathVariable int batchid, @PathVariable int studentid,
			@PathVariable String newname) {
		Batch b1 = batchRepo.findById(batchid).get();
		List<Student> list1 = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++) {
			Student s = list1.get(i);
			if (s.id == studentid)
				s.name = newname;
		}
		Batch b3 = new Batch(batchid, b1.name, b1.triner, list1);
		return "done";
	}
	//studentbachupdate--+++++----
	@RequestMapping("studentTrannerchange/{sid}/{bid}")
	public String studentTrannerchange(@PathVariable int sid,@PathVariable int bid) {
		Student s=studentRepo.findById(sid).get();
		Batch b=batchRepo.findById(bid).get();
		List<Student>list1=b.student;
		Batch b2=new Batch(bid, b.name, b.triner, list1);
		batchRepo.save(b2);
		
		return "done";
	}

	// delete-----------------------------------------------------
	@RequestMapping("deletestudentfrombatch/{batch_id}/{std_id}")
	public String deleteStudentfrombatch(@PathVariable int batch_id, @PathVariable int std_id) {
		Batch b1 = batchRepo.findById(batch_id).get();
		List<Student> list1 = b1.student;
		for (int i = 0; i < list1.size(); i++) {
			Student s = list1.get(i);
			if (std_id == s.id) {
				list1.remove(i);
			}
		}
		Batch b = new Batch(b1.id, b1.name, b1.triner, list1);
		batchRepo.save(b);
		return "done";
	}
}
