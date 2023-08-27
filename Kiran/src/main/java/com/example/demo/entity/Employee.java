package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id@GeneratedValue(strategy = GenerationType.AUTO)
private	int empId;
private	String name;
private	String phoneNumber;
private	String city;
public Employee(int empId, String name, String phoneNumber, String city) {
	super();
	this.empId = empId;
	this.name = name;
	this.phoneNumber = phoneNumber;
	this.city = city;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", city=" + city + "]";
}

}
