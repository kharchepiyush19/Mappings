package com.example.Myproject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Myproject.Component.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
