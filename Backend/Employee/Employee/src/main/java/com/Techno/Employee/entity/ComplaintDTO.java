package com.Techno.Employee.entity;

import java.util.Date;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintDTO {
	
	private Long complaintId;

    private Long employeeId;

    
    private String categoryName;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Enumerated(EnumType.STRING)
    private Status status;
	
	
	
	public enum Status {
        PENDING,
        SOLVED,
        WITHDRAWAL
    }


}
