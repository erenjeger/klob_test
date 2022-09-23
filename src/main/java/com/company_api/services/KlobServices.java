package com.company_api.services;

import com.company_api.dto.CommunityDto;
import com.company_api.dto.CompanyDto;
import com.company_api.dto.EducationDto;
import com.company_api.entity.Community;
import com.company_api.entity.Company;
import com.company_api.entity.Education;
import com.company_api.repository.CommunityRepository;
import com.company_api.repository.CompanyRepository;
import com.company_api.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class KlobServices {
    @Autowired
    CommunityRepository communityRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    EducationRepository educationRepository;

    public boolean saveCommunity(CommunityDto communityDto){
        Community community = new Community();
        boolean status;
        try {
            community.setCommunityId(UUID.randomUUID().toString());
            community.setCommunityImg(communityDto.getCommunityImg());
            community.setCommunityName(communityDto.getCommunityName());
            community.setCreateAt(new Date());
            communityRepository.save(community);
            status = true;
        }catch (Exception e){
            e.getStackTrace();
            status = false;
        }finally {

            status = true;
        }
        return status;
    }
    public boolean saveEducation(EducationDto educationDto){
        Education education = new Education();
        boolean status;
        try {
            education.setEducationId(UUID.randomUUID().toString());
            education.setEducationImg(educationDto.getEducationImg());
            education.setEducationName(educationDto.getEducationName());
            education.setCreateAt(new Date());
            educationRepository.save(education);
            status = true;
        }catch (Exception e){
            e.getStackTrace();
            status = false;
        }finally {

            status = true;
        }
        return status;
    }
    public boolean saveCompany(CompanyDto companyDto){
        Company company = new Company();
        boolean status;
        try {
            company.setCompanyId(UUID.randomUUID().toString());
            company.setCompanyAddress(companyDto.getCompanyAddress());
            company.setCompanyImg(companyDto.getCompanyImg());
            company.setCompanyName(companyDto.getCompanyName());
            company.setCompanyPhone(companyDto.getCompanyPhone());
            company.setCreateAt(new Date());
            companyRepository.save(company);
            status = true;
        }catch (Exception e){
            e.getStackTrace();
            status = false;
        }finally {

            status = true;
        }
        return status;
    }

    public boolean updateEducation(EducationDto educationDto){
        Education education = educationRepository.findByEducationId(educationDto.getEducationId());
        boolean flagUpdate;
        try {
            if (education != null) {
                    education.setEducationImg(educationDto.getEducationImg());
                    education.setEducationName(educationDto.getEducationName());
                    education.setUpdatedAt(new Date());
                flagUpdate = true;
                educationRepository.save(education);
            } else {
                flagUpdate = false;
            }
        }catch (Exception e){
            flagUpdate = false;
            e.getStackTrace();
        }
        return flagUpdate;
    }

    public boolean updateCommunity(CommunityDto communityDto){
        Community community = communityRepository.findByCommunityId(communityDto.getCommunityId());
        boolean flagUpdate;
        try {
            if (community != null) {
                    community.setCommunityImg(communityDto.getCommunityImg());
                    community.setCommunityName(communityDto.getCommunityName());
                    community.setUpdatedAt(new Date());
                flagUpdate = true;
                communityRepository.save(community);
            } else {
                flagUpdate = false;
            }
        }catch (Exception e){
            flagUpdate = false;
            e.getStackTrace();
        }
        return flagUpdate;
    }
    public boolean updateCompany(CompanyDto companyDto){
        Company company = companyRepository.findByCompanyId(companyDto.getCompanyId());
        boolean flagUpdate;
        try {
            if (company != null) {
                company.setCompanyPhone(companyDto.getCompanyPhone());
                company.setCompanyImg(companyDto.getCompanyImg());
                company.setCompanyAddress(companyDto.getCompanyAddress());
                company.setCompanyName(companyDto.getCompanyName());
                company.setUpdatedAt(new Date());
                flagUpdate = true;
                companyRepository.save(company);
            } else {
                flagUpdate = false;
            }
        }catch (Exception e){
            flagUpdate = false;
            e.getStackTrace();
        }
        return flagUpdate;
    }
    public void deleteEducationById(String idEducation){
        educationRepository.deleteById(idEducation);
    }
    public void deleteCompanyById(String idCompany){
        companyRepository.deleteById(idCompany);
    }
    public void deleteCommunityById(String idCommunity){
        communityRepository.deleteById(idCommunity);
    }

    public List<Education> findAllEducation(){
        return educationRepository.findAll();
    }
    public List<Company> findAllCompany(){
        return companyRepository.findAll();
    }
    public List<Community> findAllCommunity(){
        return communityRepository.findAll();
    }

    public Community findByCommunityById(String idCommunity){
        return communityRepository.findByCommunityId(idCommunity);
    }
    public Education findByEducationById(String idEducation){
        return educationRepository.findByEducationId(idEducation);
    }
    public Company findByCompanyById(String idCompany){
        return companyRepository.findByCompanyId(idCompany);
    }
}
