package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	List<Student> findByFirstname(String Firstname);

	List<Student> findByFirstnameEquals(String firstname);

	List<Student> findByFirstnameIs(String firstname);

	List<Student> findByFirstnameLike(String Firstname);

	List<Student> findByFirstnameNotLike(String Firstname);

	List<Student> findByLastname(String Lastname);

	List<Student> findByLastnameIgnoreCase(String lastname);

	List<Student> findByLastnameAllIgnoreCase(String lastname);

	List<Student> findByLastnameNot(String lastname);

	List<Student> findByAgeOrderByLastnameDesc(int age);

	List<Student> findByAgeOrderByLastname(int age);

	List<Student> findByMarksGreaterThanOrderByMarks(int marks);

	@Query(value = "select * from student ", nativeQuery = true)
	List<Student> allStudentdatashowtable();

	@Query(value = "select * from student where marks>?1", nativeQuery = true)
	List<Student> allStudengrtermark(int marks);

	@Query(value = "select first_name,id from student", nativeQuery = true)
	List<IdFirstName> getidfirstname();

	Student findByFirstnameAndLastname(String Firstname, String lastname);

	List<Student> findByFirstnameOrLastname(String Firstname, String lastname);

	List<Student> findByAgeLessThan(int age);

	List<Student>findByFirstnameStartingWith(String firstname);

}
