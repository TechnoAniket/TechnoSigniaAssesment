package com.Techno.Complaint.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Techno.Complaint.entity.Complaint;
import com.Techno.Complaint.repository.ComplaintRespository;
@Service
public class ComplaintService implements c {

	@Autowired
	private ComplaintRespository complaintRespository;
	
	@Override
	public Complaint create(Complaint complaint) {
               
		complaint.setCreatedDate(LocalDate.now());
		return complaintRespository.save(complaint);
	}

	@Override
	public List<Complaint> fetchAll() {
		return complaintRespository.findAll();
	}

	@Override
	public Complaint getByIdComplaint(Long id) {
		return complaintRespository.findById(id).get();
	}

	@Override
	public String delByComplaintid(Long id) {
		complaintRespository.deleteById(id);
		return "deleted..!";
	}

	@Override
	 public Complaint updateComplaint(Complaint updatedComplaint, Long id) {
        Complaint oldComplaint = complaintRespository.findById(id).orElse(null);
        if (oldComplaint != null) {
            if (updatedComplaint.getEmployeeId() != null) {
                oldComplaint.setEmployeeId(updatedComplaint.getEmployeeId());
            }
            if (updatedComplaint.getCategoryName() != null) {
                oldComplaint.setCategoryName(updatedComplaint.getCategoryName());
            }
            if (updatedComplaint.getDescription() != null) {
                oldComplaint.setDescription(updatedComplaint.getDescription());
            }
            if (updatedComplaint != null) {
                oldComplaint.setCreatedDate(LocalDate.now());
            }
            if (updatedComplaint.getStatus() != null) {
                oldComplaint.setStatus(updatedComplaint.getStatus());
            }

            return complaintRespository.save(oldComplaint);
        }
        return null; // Or throw an exception indicating the complaint with the given id doesn't exist
    }

	public List<Complaint> getAllComplaintsByEmployeeId(Long employee_Id) {
		return complaintRespository.findAllByEmployeeId(employee_Id);
	}

}
