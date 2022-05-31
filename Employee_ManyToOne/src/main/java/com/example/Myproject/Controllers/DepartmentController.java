package com.example.Myproject.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Myproject.Components.Department;
import com.example.Myproject.Repo.DepartmentRepo;
import com.example.Myproject.Repo.EmployeeRepo;

@RestController
@RequestMapping("dept")
public class DepartmentController {

	@Autowired
	DepartmentRepo dr;
	
	@Autowired
	EmployeeRepo er;
	
	@RequestMapping("read")
	public List<Department> read(){
		return dr.findAll();
	}
	
	@RequestMapping("delete{deptid}")
	public boolean delete(@PathVariable int deptid) {
		try {
			dr.deleteById(deptid);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping("save")
	public boolean save(@RequestBody Department d) {
		try {
			dr.save(d);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
