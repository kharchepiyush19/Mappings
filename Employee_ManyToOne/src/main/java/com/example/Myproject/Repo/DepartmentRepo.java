package com.example.Myproject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Myproject.Components.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
