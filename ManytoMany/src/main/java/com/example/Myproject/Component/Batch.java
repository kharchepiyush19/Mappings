package com.example.Myproject.Component;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
	String trainer;
	String month;
	@ManyToMany(mappedBy = "batches")
	@JsonIgnore
	Set<Student> students;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Batch [id=" + id + ", trainer=" + trainer +
				", month=" + month + ", students=" + students + "]";
	}
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Batch(int id, String trainer, String month, Set<Student> students) {
		super();
		this.id = id;
		this.trainer = trainer;
		this.month = month;
		this.students = students;
	}
	
	
}
