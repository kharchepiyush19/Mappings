package com.example.Myproject.Components;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	
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
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Department() {
		super();
		
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	
}
