package com.example.Myproject.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Myproject.component.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	List<Student> findByMarks(int n);
}
