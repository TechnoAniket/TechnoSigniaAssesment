package com.Techno.Complaint.service;

import java.util.List;

import com.Techno.Complaint.entity.Complaint;

public interface c {

	Complaint create(Complaint complaint);
	
	List<Complaint> fetchAll();
	
	Complaint getByIdComplaint(Long id);
	
	String delByComplaintid(Long id);
	
	Complaint updateComplaint(Complaint complaint , Long id);
	
}
