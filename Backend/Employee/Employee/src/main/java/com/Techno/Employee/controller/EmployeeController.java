package com.Techno.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Techno.Employee.entity.Employee;
import com.Techno.Employee.entity.EmployeeWithComplaint;
import com.Techno.Employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee employee){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.createEmployee(employee));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> fetchAll(){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.fetchAllEmployee());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeebyId(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.updateEmployee(employee, id));
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> delEmployee(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteEmployee(id));
		
	}
	
	@GetMapping("/empComplaints/{id}")
	public ResponseEntity<EmployeeWithComplaint> employeeComplaint(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.employeeComplaints(id));
	}
}
