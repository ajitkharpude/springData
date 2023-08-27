package com.in.compared;

public class Employees implements Comparable<Employees>  {
	int id;
	String name;
	public Employees(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Employees() {
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
		return "Employees [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Employees o) {
		// TODO Auto-generated method stub
		if(id==o.id)
			return 0;
		else if(id>o.id)
			return 1;
		else
		return -1;
		
		//return name.compareTo(o.name);
	}
	
	
}
