package com.Techno.Complaint.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Techno.Complaint.entity.Complaint;

import java.util.List;

@Repository
public interface ComplaintRespository extends JpaRepository<Complaint, Long> {

	List<Complaint> findAllByEmployeeId(Long employee_Id);
	
}
