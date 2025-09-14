package com.loanCheckerApi.LoanCecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanCheckerApi.LoanCecker.entites.Applicant;
import com.loanCheckerApi.LoanCecker.service.ApplicantService;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

	@Autowired
	private ApplicantService applicantService;
	
	@PostMapping("/add")
	public ResponseEntity<Applicant> saveApplicant(@RequestBody Applicant applicant){
		Applicant savedApplicant = applicantService.saveApplicant(applicant);
		return ResponseEntity.ok(savedApplicant);
	}
	
	@GetMapping("/{id}/eligibility")
	public ResponseEntity<String> checkEligibility(@PathVariable Long id){
		return applicantService.getApplicant(id)
				.map(applicant -> {
					boolean eligible = applicantService.isEligible(applicant);
					String message = eligible ? "Eligible for loan" : "Not eligible for loan";
					return ResponseEntity.ok(message);
				}).orElse(ResponseEntity.notFound().build());
	}
}
