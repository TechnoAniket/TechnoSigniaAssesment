package com.Techno.Complaint.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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



	  public void setCreatedDate(LocalDate localDate) {
	        // Convert LocalDate to java.util.Date before setting createdDate
	        this.createdDate = java.sql.Date.valueOf(localDate);
	    }

}
