package com.Techno.ComplaintCategory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Techno.ComplaintCategory.entity.ComplaintCategory;
import com.Techno.ComplaintCategory.service.ComplaintCategoryService;

@RestController
@RequestMapping("/complaintcategory")
public class ComplaintCategoryContoller {
	
	@Autowired
	private ComplaintCategoryService complaintCategoryService;
	
	@PostMapping("/save")
	public ResponseEntity<ComplaintCategory> create(@RequestBody ComplaintCategory complaintCategory){
		return ResponseEntity.status(HttpStatus.OK).body(complaintCategoryService.saveComplaintCategory(complaintCategory));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<ComplaintCategory>> getAllComplaintCategory(){
		return ResponseEntity.status(HttpStatus.OK).body(complaintCategoryService.getAllComplaintCategory()) ;
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<ComplaintCategory> getComplaintCategory(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(complaintCategoryService.getByIdComplaintCategory(id));
		
	}
	
	@DeleteMapping("/del/{id}")
	public ResponseEntity<String> delComplaintCategory(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(complaintCategoryService.delComplaintCategory(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ComplaintCategory> updateComplaintCategory(@RequestBody ComplaintCategory complaintCategory,@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.CREATED).body(complaintCategoryService.update(complaintCategory, id));
	}
	

}
