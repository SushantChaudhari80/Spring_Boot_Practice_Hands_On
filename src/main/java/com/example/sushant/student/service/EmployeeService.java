package com.example.sushant.student.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sushant.student.model.Employee_Model;
import com.example.sushant.student.repository.EmployeeRepository;

import antlr.collections.List;

@Service
public class EmployeeService 
{
	@Autowired
	EmployeeRepository repo;

	public ArrayList findall(){
		return (ArrayList) repo.findAll();
	}
	public String addEmp(Employee_Model model) {
		try {
			repo.save(model);
			return "Employee Added Succesfully..";
		}catch(Exception e) {
			return "Backend Error";
		}
	}
	public String updateEmp(String id,Employee_Model model) {
		try {
			ArrayList list=(ArrayList) repo.findAll();
			for(int i=0;i<list.size();i++) {
				Employee_Model m=(Employee_Model) list.get(i);
				if(m.getId().equals(id)) {
					m.setName(model.getName());
					m.setSalary(model.getSalary());
					repo.save(m);
				}
			}
			
			return "Employee Data updated Successfull..";
		}catch(Exception e) {
			return "";
		}
	}
	public Optional<Employee_Model> getEmp(String id) {
		return repo.findById(id);
	}
	public String deleteEmp(String id) {
		try {
			repo.deleteById(id);
			return "Employee Deleted Succesfully..";
		}catch(Exception e) {
			return "Backend Error";
		}
	}
	public String dltAllEmp() {
		try {
			((EmployeeService) repo).dltAllEmp();
			return "Employee Deleted Succesfully..";
		}catch(Exception e) {
			return "Backend Error";
		}
	}
}
