package com.example.Myproject.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Myproject.Component.Batch;
import com.example.Myproject.Repo.BatchRepo;
import com.example.Myproject.Repo.StudentRepo;

@RestController
@RequestMapping("batch")
public class BatchController {

	@Autowired
	StudentRepo sr;
	@Autowired
	BatchRepo br;
	
	@RequestMapping("read")
	List<Batch> savestudent(@PathVariable Batch b) {
		return br.findAll();
		
	}
	
	@RequestMapping("save")
	public boolean add(@RequestBody Batch b) {
		try {
			br.save(b);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
