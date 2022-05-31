package com.example.Myproject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Myproject.Components.Employee;
import com.example.Myproject.Repo.DepartmentRepo;
import com.example.Myproject.Repo.EmployeeRepo;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	DepartmentRepo dr;
	
	@Autowired
	EmployeeRepo er;
	
	@RequestMapping("read")
	public List<Employee> read() {
		try {
			return er.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping("save1")
	public boolean save(@RequestBody Employee e) {
		try {
			er.save(e);
			return true;
		} catch (Exception e2) {
			e2.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("delete{id}")
	public boolean delete(@PathVariable int id) {
		try {
			er.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
