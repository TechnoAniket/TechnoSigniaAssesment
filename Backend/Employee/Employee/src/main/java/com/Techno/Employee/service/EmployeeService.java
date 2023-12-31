package com.Techno.Employee.service;

import java.util.List;

import com.Techno.Employee.entity.Employee;
import com.Techno.Employee.entity.EmployeeWithComplaint;

public interface EmployeeService {

	Employee createEmployee(Employee employee);
	
	List<Employee> fetchAllEmployee();
	
	String deleteEmployee(Long id);
	
	Employee updateEmployee(Employee employee,Long id);
	
	Employee getEmployeebyId(Long id);
	
	EmployeeWithComplaint employeeComplaints(Long id);
}
