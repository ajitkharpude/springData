package com.in.compared;

public class Emp2  {
int id;
String name;
public Emp2(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public Emp2() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Emp2 [id=" + id + ", name=" + name + "]";
}

}
