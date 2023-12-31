package com.Techno.Employee.entity;

import java.util.List;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWithComplaint {

	private String name;

	private String email;
	@Transient
	private List<ComplaintDTO> complaintDTO;
}
