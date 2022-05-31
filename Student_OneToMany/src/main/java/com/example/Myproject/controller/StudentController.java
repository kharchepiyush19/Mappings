package com.example.Myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Myproject.Repo.BatchRepo;
import com.example.Myproject.Repo.StudentRepo;
import com.example.Myproject.component.Batch;
import com.example.Myproject.component.Student;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	StudentRepo sr;
	
	@Autowired
	BatchRepo br;
	

	@RequestMapping("save{batchId}")
	public boolean save(@RequestBody Student s1, @PathVariable int batchId) {
//save in Student
		sr.save(s1);
//save in Batch
		Batch b1=br.findById(batchId).get();
		List<Student> s=b1.getL();
		s.add(s1);
		br.save(b1);
		return true;
	}
	
	@RequestMapping("removestudentfrombatch{batchId}and{studentid}")
	public boolean remove(@PathVariable int batchId, @PathVariable int studentId) {
		try {
//Delete from Batch
			Batch b1=(Batch) br.findById(batchId).get();
			List<Student> students=b1.getL();
			for (Student s : students) {
				if(s.getRn()==studentId) {
					students.remove(s);
					break;
				}
			}
			br.save(b1);
//Delete from Student
			sr.deleteById(studentId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
