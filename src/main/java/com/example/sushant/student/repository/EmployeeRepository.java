package com.example.sushant.student.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sushant.student.model.Employee_Model;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee_Model, String>{

}
