package com.company_api.repository;

import com.company_api.entity.Company;
import com.company_api.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, String> {
    Education findByEducationId(String educationId);
    List<Education> findAll();
}
