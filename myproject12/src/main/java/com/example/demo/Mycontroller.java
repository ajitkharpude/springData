package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {
	@Autowired
	StudentRepo studentReop;

	@RequestMapping("getcount")
	public long getCount() {
		return studentReop.count();
		// TODO Auto-generated method stub

	}

	@RequestMapping("show")
	public List<Student> showdata() {
		return studentReop.findAll();
		// TODO Auto-generated method stub

	}

	@RequestMapping("save")
	private Student save(@RequestBody Student student) {

		return studentReop.save(student);
		// TODO Auto-generated method stub

	}

	@RequestMapping("delete{id}")
	private boolean save(@PathVariable int id) {

		try {
			studentReop.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exceptionretur
			return false;
		}

	}
	/*
	 * @RequestMapping("between{marks}/{marks1}") public List<Student>
	 * getbetween(@PathVariable int marks,@PathVariable int marks1) { return
	 * studentReop.Between(marks, marks1); // TODO Auto-generated method stub;
	 * 
	 * }
	 */

	@RequestMapping("findbyFirstname{firstname}")
	public List<Student> getStudentname(@PathVariable String firstname) {
		return studentReop.findByFirstname(firstname);
		// TODO Auto-generated method stub;

	}

	@RequestMapping("findbyFirstnameis{firstname}")
	public List<Student> getStudentnameistostudent(@PathVariable String firstname) {
		return studentReop.findByFirstnameIs(firstname);
		// TODO Auto-generated method stub;

	}

	@RequestMapping("findbyFirstnamelike{firstname}")
	public List<Student> getStudentnamelikeistostudent(@PathVariable String firstname) {
		return studentReop.findByFirstnameLike(firstname);
		// TODO Auto-generated method stub;

	}

	@RequestMapping("findbyFirstnameNotlike{firstname}")
	public List<Student> getStudentnamenotlikeistostudent(@PathVariable String firstname) {
		return studentReop.findByFirstnameNotLike(firstname);
		// TODO Auto-generated method stub;

	}

	@RequestMapping("findbyFirstnameEqual{firstname}")
	public List<Student> getStudentnameequaltostudent(@PathVariable String firstname) {
		return studentReop.findByFirstnameEquals(firstname);
		// TODO Auto-generated method stub;

	}
@RequestMapping("findbyfirstnamestartingwith/{firstname}")
	public List<Student> findbyfirstnamestartingwith(@PathVariable String firstname) {
		return studentReop.findByFirstnameStartingWith(firstname);
	}

	@RequestMapping("findbyLastname{lastname}")
	public List<Student> getStudentlastname(@PathVariable String lastname) {
		return studentReop.findByLastname(lastname);
		// TODO Auto-generated method stub;

	}

	@RequestMapping("findbyage{age}")
	public List<Student> getStudentlessthanAge(@PathVariable int age) {
		return studentReop.findByAgeLessThan(age);
		// TODO Auto-generated method stub;

	}

	@RequestMapping("findByAgeOrderByLastnameDesc{age}")
	public List<Student> findByAgeOrderByLastnameDescinStudent(@PathVariable int age) {
		return studentReop.findByAgeOrderByLastnameDesc(age);
		// TODO Auto-generated method stub;

	}

	@RequestMapping("findByAgeOrderByLastname{age}")
	public List<Student> findByAgeOrderByLastnameinStudent(@PathVariable int age) {
		return studentReop.findByAgeOrderByLastname(age);
		// TODO Auto-generated method stub;

	}

	@RequestMapping("findbyFirstnameAndLastname{firstname}/{lastname}")
	public Student getStudentLastnameAndFirstNameintable(@PathVariable String firstname,
			@PathVariable String lastname) {
		return studentReop.findByFirstnameAndLastname(firstname, lastname);
		// TODO Auto-generated method stub;

	}

	@RequestMapping("findbyFirstnameorLastname{firstname}/{lastname}")
	public List<Student> getStudentLastnameOrFirstNameintable(@PathVariable String firstname,
			@PathVariable String lastname) {
		return studentReop.findByFirstnameOrLastname(firstname, lastname);
		// TODO Auto-generated method stub;

	}

	@RequestMapping("findbyMarks{marks}")
	public List<Student> getStudentMarks(@PathVariable int marks) {
		return studentReop.findByMarksGreaterThanOrderByMarks(marks);
		// TODO Auto-generated method stub;

	}

	@RequestMapping("getstudentdata")
	List<Student> allStudentdatashowtable() {
		return studentReop.allStudentdatashowtable();
	}

	@RequestMapping("getstudentgretermarks{marks}")
	List<Student> allStudentgretermark(@PathVariable int marks) {
		return studentReop.allStudengrtermark(marks);
	}

	@RequestMapping("showIdFirstName")
	public List<IdFirstName> getIdFirstname() {

		return studentReop.getidfirstname();
	}

	@RequestMapping("findbyLastnameignored/{lastname}")
	public List<Student> findByLastnameIgnoreCaseinstudent(@PathVariable String lastname) {
		return studentReop.findByLastnameIgnoreCase(lastname);
	}

	@RequestMapping("findbyLastnameallignored/{lastname}")
	public List<Student> findByLastnameAllIgnoreCaseinstudent(@PathVariable String lastname) {
		return studentReop.findByLastnameAllIgnoreCase(lastname);
	}

	@RequestMapping("findbyLastnamenot/{lastname}")
	public List<Student> findByLastnameNotinstudent(@PathVariable String lastname) {
		return studentReop.findByLastnameNot(lastname);
	}

}
