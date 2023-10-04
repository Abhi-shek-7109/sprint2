package com.SchoolProject2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// ... (other imports)

import com.SchoolProject2.entity.Department; // Change import
import com.SchoolProject2.exception.DepartmentNotFoundException;
import com.SchoolProject2.repository.DepartmentRepository; // Change import


@Service
public class DepartmentService {

	
    @Autowired
   
    private DepartmentRepository drepo;

    public List<Department> getAllDepartments() {
        return drepo.findAll();
    }

    public Department saveDepartment(Department department) {
        Department department1 = Department.builder()
                .dname(department.getDname())
                .demail(department.getDemail())
                .dphone(department.getDphone())
                .designation(department.getDesignation())
                .employee(department.getEmployee())
                .build();
        return drepo.save(department1);
    }

    public Department getDepartment(int did) throws DepartmentNotFoundException { 
        Department department = drepo.findById(did);
        if (department != null) {
            return department;
        } else
            throw new DepartmentNotFoundException("Department not found with id:" + did);
    }

    public Department updateDepartmentDetail(Department department, int did) { 
        Department updatedDepartment = drepo.findById(did);
        if (updatedDepartment != null) {
            updatedDepartment.setDphone(department.getDphone());
            updatedDepartment.setDesignation(department.getDesignation());
            drepo.save(updatedDepartment);
        }
        return updatedDepartment;
    }

    public void deleteDepartment(int did) { 
        Department department = drepo.findById(did);
        if (department != null) {
            drepo.deleteById(did);
        }
    }
}
