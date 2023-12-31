package com.Techno.ComplaintCategory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintCategory {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long categoryId;

	    private Long employeeId;

	    
	    private String categoryName;

	    @Enumerated(EnumType.STRING)
	    private Status status;

	    public enum Status {
	        ACTIVE,
	        INACTIVE
	    }

}
