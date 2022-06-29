package com.example.sushant.student.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sushant.student.model.Employee_Model;
import com.example.sushant.student.service.EmployeeService;

import antlr.collections.List;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/getAllEmp")
	public ArrayList getAllEmp() {
		return service.findall();
	}
	
	@PutMapping("/add")
	public String addEmp(Employee_Model model) {
		return service.addEmp(model);
	}
	@DeleteMapping("deleteEmp/{id}")
	public String dltEmp(@PathVariable String id) {
		return service.deleteEmp(id);
	}
	
	@PostMapping("updateEmp/{id}")
	public String updateEmp(@PathVariable String id,@RequestBody Employee_Model model) {
		return service.updateEmp(id, model);
	}
	@GetMapping("getEmp/{id}")
	public Optional<Employee_Model> getEmp(String id) {
		return service.getEmp(id);
	}
}
