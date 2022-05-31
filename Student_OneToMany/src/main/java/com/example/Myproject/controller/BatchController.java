package com.example.Myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Myproject.Repo.BatchRepo;
import com.example.Myproject.Repo.StudentRepo;
import com.example.Myproject.component.Batch;
import com.example.Myproject.component.Student;

@RestController
@RequestMapping("batch")
public class BatchController {
	
	@Autowired
	BatchRepo br;
	@Autowired
	StudentRepo sr;
	
	@PostMapping("save")
	boolean save(@RequestBody Batch b) {
		try {
			if(b.getMonth()==null || b.getMonth().isEmpty() || b.getMonth().isBlank() 
				|| b.getTrainer()==null|| b.getTrainer().isBlank() || b.getTrainer().isEmpty()) {
				return false;
			}
			else {
				br.save(b);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@GetMapping("read")
	public List<Batch> read(){
		try {
			return br.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@DeleteMapping("delete{id}")
	boolean delete(@PathVariable int id) {
		try {
			Batch b=br.findById(id).get();
			List<Student> s=b.getL();
			if(s.size()>0)
				return false;
			
			br.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
