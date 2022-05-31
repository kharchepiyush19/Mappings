package com.example.Myproject;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {

	StudentRepo studRepo;
	
	MyClass(StudentRepo sr){
		studRepo=sr;
	}

	@GetMapping("create")
	public boolean add(@RequestBody Student s){
		studRepo.save(s);
		System.out.println(s);
		return true;
	}
	
	@RequestMapping(path="check{id}",method = RequestMethod.GET)
	public int checkForAvailable(@PathVariable int id) {
		try {
			studRepo.findById(id);
			return 1;
		} 
		catch (Exception e) {return 0;	}
	}
	
	@DeleteMapping("delete{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			studRepo.deleteById(id);
			return true;
		} catch (Exception e) {return false;}
	}
	
	@GetMapping ("read")
	public List<Student> readall(@PathVariable int id) {
		try {
			return studRepo.findAll();
			
		} catch (Exception e) {return null;}
	}
	
	
	
}
