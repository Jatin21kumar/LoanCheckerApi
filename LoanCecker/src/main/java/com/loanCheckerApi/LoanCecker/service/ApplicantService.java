package com.loanCheckerApi.LoanCecker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanCheckerApi.LoanCecker.entites.Applicant;
import com.loanCheckerApi.LoanCecker.ropository.ApplicantRepository;

@Service
public class ApplicantService {

	@Autowired
	private ApplicantRepository applicantRepository;
	
	public Applicant saveApplicant(Applicant applicant) {
		return applicantRepository.save(applicant);
	}
	
	public Optional<Applicant> getApplicant(Long id) {
		return applicantRepository.findById(id);
	}
	
	public boolean isEligible(Applicant applicant) {
		return applicant.getSalary() >= 50000
                && applicant.getCreditScore() >= 700
                && applicant.getBalance() >= 10000;
	}
}
