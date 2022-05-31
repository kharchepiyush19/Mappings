package com.example.Myproject.component;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String month;
	String trainer;
	@OneToMany
	List<Student> l;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public List<Student> getL() {
		return l;
	}
	public void setL(List<Student> l) {
		this.l = l;
	}
	public Batch(int id, String month, String trainer, List<Student> l) {
		super();
		this.id = id;
		this.month = month;
		this.trainer = trainer;
		this.l = l;
	}
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Batch [id=" + id + ", month=" + month + ", trainer=" + trainer + ", l=" + l + "]";
	}
	
	
	
}
