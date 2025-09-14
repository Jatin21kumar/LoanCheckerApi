package com.loanCheckerApi.LoanCecker.ropository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loanCheckerApi.LoanCecker.entites.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long>{
	
}
