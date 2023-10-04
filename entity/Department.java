package com.SchoolProject2.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder  
public class Department {

    @Id
    @GeneratedValue
    private int did;

    @Column(length = 25, nullable = false)
    private String dname;

    @Column(length = 25, nullable = false, unique = true)
    private String demail;

    @Column(length = 11, nullable = false, unique = true)
    private long dphone;

    @Column(length = 25, nullable = false)
    private String designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_fk", referencedColumnName = "eid")
    private Employee employee;
}
