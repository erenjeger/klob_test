package com.company_api.repository;

import com.company_api.entity.Community;
import com.company_api.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
    Company findByCompanyId(String companyId);
    List<Company> findAll();
}
