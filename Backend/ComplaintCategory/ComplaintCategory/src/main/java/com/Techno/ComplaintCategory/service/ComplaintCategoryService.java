package com.Techno.ComplaintCategory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Techno.ComplaintCategory.entity.ComplaintCategory;
import com.Techno.ComplaintCategory.repository.ComplaintCategoryRepository;

@Service
public class ComplaintCategoryService implements cc {

	@Autowired
	private ComplaintCategoryRepository complaintCategoryRepository;

	@Override
	public ComplaintCategory saveComplaintCategory(ComplaintCategory complaintCategory) {
		return complaintCategoryRepository.save(complaintCategory);
	}

	@Override
	public List<ComplaintCategory> getAllComplaintCategory() {
		return complaintCategoryRepository.findAll();
	}

	@Override
	public ComplaintCategory getByIdComplaintCategory(Long id) {

		return complaintCategoryRepository.findById(id).get();
	}

	@Override
	public String delComplaintCategory(Long id) {
		complaintCategoryRepository.deleteById(id);
		return "ComplaintCategory deleted..!";
	}

	@Override
	public ComplaintCategory update(ComplaintCategory updatedCategory, Long id) {
		ComplaintCategory oldCategory = complaintCategoryRepository.findById(id).orElse(null);
		if (oldCategory != null) {
			if (updatedCategory.getCategoryId() != null) {
				oldCategory.setCategoryId(updatedCategory.getCategoryId());
			}
			if (updatedCategory.getEmployeeId() != null) {
				oldCategory.setEmployeeId(updatedCategory.getEmployeeId());
			}
			if (updatedCategory.getCategoryName() != null) {
				oldCategory.setCategoryName(updatedCategory.getCategoryName());
			}
			if (updatedCategory.getStatus() != null) {
				oldCategory.setStatus(updatedCategory.getStatus());
			}
			return complaintCategoryRepository.save(oldCategory);
		}
		return null;
	}
}
