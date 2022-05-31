package com.example.Myproject.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Myproject.Components.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	
	
}
