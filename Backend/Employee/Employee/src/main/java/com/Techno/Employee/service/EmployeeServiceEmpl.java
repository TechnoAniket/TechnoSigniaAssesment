package com.Techno.Employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Techno.Employee.entity.ComplaintDTO;
import com.Techno.Employee.entity.Employee;
import com.Techno.Employee.entity.EmployeeWithComplaint;
import com.Techno.Employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceEmpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired 
	private RestTemplate restTemplate;
	@Autowired
	private EmployeeWithComplaint empComplaint;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public String deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		return "Employee deleted !!!";
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		Employee oldEmployee = employeeRepository.findById(id).orElse(null);
		if (oldEmployee != null) {
			if (employee.getName() != null) {
				oldEmployee.setName(employee.getName());
			}
			if (employee.getAddress() != null) {
				oldEmployee.setAddress(employee.getAddress());
			}
			if (employee.getMobile() != null) {
				oldEmployee.setMobile(employee.getMobile());
			}
			if (employee.getEmail() != null) {
				oldEmployee.setEmail(employee.getEmail());
			}
			if (employee.getGender() != null) {
				oldEmployee.setGender(employee.getGender());
			}
			if (employee.getDateOfBirth() != null) {
				oldEmployee.setDateOfBirth(employee.getDateOfBirth());
			}
			if (employee.getDepartment() != null) {
				oldEmployee.setDepartment(employee.getDepartment());
			}
			if (employee.getJobTitle() != null) {
				oldEmployee.setJobTitle(employee.getJobTitle());
			}

			return employeeRepository.save(oldEmployee);
		}
		return null;
	}

	@Override
	public Employee getEmployeebyId(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public EmployeeWithComplaint employeeComplaints(Long id) {

		Employee emp = employeeRepository.findById(id).get();
		List<ComplaintDTO> comp = restTemplate.getForObject("http://localhost:8083/complaint/complainEmp/" + id,
				ArrayList.class);

		empComplaint.setName(emp.getName());
		empComplaint.setEmail(emp.getEmail());
		empComplaint.setComplaintDTO(comp);
		return empComplaint;
	}
}
