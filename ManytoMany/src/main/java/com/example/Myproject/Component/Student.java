package com.example.Myproject.Component;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int rn;
	String name;
	int marks;
	@ManyToMany
	Set<Batch> batches;
	public int getRn() {
		return rn;
	}
	public void setRn(int rn) {
		this.rn = rn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Set<Batch> getBatches() {
		return batches;
	}
	public void setBatchs(Set<Batch> batches) {
		this.batches = batches;
	}
	public Student() {
		
	}
	public Student(int rn, String name, int marks, Set<Batch> batches) {
		super();
		this.rn = rn;
		this.name = name;
		this.marks = marks;
		this.batches = batches;
	}
	@Override
	public String toString() {
		return "Student [rn=" + rn + ", name=" + name + ","
				+ " marks=" + marks + ", batches=" + batches + "]";
	}
	
	
}
