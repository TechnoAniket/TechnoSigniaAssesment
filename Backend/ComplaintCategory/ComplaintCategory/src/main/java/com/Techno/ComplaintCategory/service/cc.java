package com.Techno.ComplaintCategory.service;

import java.util.List;

import com.Techno.ComplaintCategory.entity.ComplaintCategory;

public interface cc {

	ComplaintCategory saveComplaintCategory(ComplaintCategory complaintCategory);
	
	List<ComplaintCategory> getAllComplaintCategory();
	
	ComplaintCategory getByIdComplaintCategory(Long id);
	
	String delComplaintCategory(Long id);
	
	ComplaintCategory update(ComplaintCategory complaintCategory,Long id);
}
