package com.SchoolProject2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Employee { 
    @Id
    @GeneratedValue
    private int eid;

    @Column(length = 25, nullable = false)
    @NotBlank(message = "Employee Name cannot be blank")
    private String efname; 

    @Column(length = 25)
    private String elname; 

    @Column(length = 25, nullable = false, unique = true)
    @NotNull(message = "Employee phone cannot be null")
    private long ephone; 

    @Column(length = 25, nullable = false, unique = true)
    @NotBlank(message = "Employee Email cannot be blank")
    @Email(message = "Email is incorrect")
    private String eemail; 

    @Column(length = 50, nullable = false)
    @NotBlank(message = "Employee education cannot be blank")
    private String eedu; 

    @Column(length = 50, nullable = false)
    @NotBlank(message = "Employee Address cannot be blank")
    private String eadd; 

}
