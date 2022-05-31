package com.example.Myproject.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Myproject.Component.Batch;
import com.example.Myproject.Component.Student;
import com.example.Myproject.Repo.BatchRepo;
import com.example.Myproject.Repo.StudentRepo;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	StudentRepo sr;
	@Autowired
	BatchRepo br;
	
	
	@RequestMapping("read")
	List<Student> readstudent() {
		try {
			return sr.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	@RequestMapping("save")
	boolean savestudent(@RequestBody Student s) {
		System.out.println("Hii");
		sr.save(s);
		return true;
	}
	
	@RequestMapping("add{studentid}and{batchid}")
	public boolean add(@PathVariable int studentid,@PathVariable int batchid) {
		try {
			Student s=sr.findById(studentid).get();
			Batch b=br.findById(batchid).get();
			
			Set<Batch> batches=s.getBatches();
			batches.add(b);
			sr.save(s);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
