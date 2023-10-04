package com.SchoolProject2.repository;

import com.SchoolProject2.entity.Department; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Department findById(int did);

}
