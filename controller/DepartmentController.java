package com.SchoolProject2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ... (other imports)

import com.SchoolProject2.entity.Department; // Change import
import com.SchoolProject2.exception.DepartmentNotFoundException;
import com.SchoolProject2.service.DepartmentService; // Change import

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api") 
public class DepartmentController {

    @Autowired
    private DepartmentService dservice;

    @PostMapping("/department/signup")
    public ResponseEntity<Department> saveDepartment(@RequestBody @Valid Department department) {
        return new ResponseEntity<>(dservice.saveDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping("/department/findAll") 
    public ResponseEntity<List<Department>> getAllDepartmentInfo() {
        return ResponseEntity.ok(dservice.getAllDepartments());
    }

    @GetMapping("/department/find/{did}") 
    public ResponseEntity<Department> getDepartment(@PathVariable int did) throws DepartmentNotFoundException {
        return ResponseEntity.ok(dservice.getDepartment(did));
    }

    @PutMapping("/department/editDepartment/{did}") 
    public ResponseEntity<Department> editDepartment(@Valid @PathVariable("did") int did, @RequestBody Department department) {
        return new ResponseEntity<Department>(dservice.updateDepartmentDetail(department, did), HttpStatus.OK);
    }

    @DeleteMapping("department/deleteDepartment/{did}") 
    public ResponseEntity<String> deleteDepartment(@PathVariable("did") int did) {
        dservice.deleteDepartment(did);
        return new ResponseEntity<String>("Deleted Successfully..", HttpStatus.OK);
    }
}
