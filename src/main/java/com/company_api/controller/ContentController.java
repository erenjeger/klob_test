package com.company_api.controller;

import com.company_api.dto.CommunityDto;
import com.company_api.dto.CompanyDto;
import com.company_api.dto.EducationDto;
import com.company_api.entity.Community;
import com.company_api.services.KlobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private KlobServices klobServices;

    @PostMapping(value = "/new-community")
    public ResponseEntity<?> addCommunity(@ModelAttribute CommunityDto communityDto, @RequestParam("image") MultipartFile file ) throws IOException {
        communityDto.setCommunityImg(file.getBytes());
        Map<String, Object> mapResponse = new HashMap<>();

        mapResponse.put("data", "");

        if (!communityDto.getCommunityName().isEmpty() && communityDto.getCommunityImg() != null) {
            boolean flagSave = klobServices.saveCommunity(communityDto);
            if (flagSave) {
                mapResponse.put("message", flagSave);
                return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
            } else {
                mapResponse.put("message", flagSave);
                return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);
            }
        }else{
            mapResponse.put("message", "field is empty.!");
            return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/new-company")
    public ResponseEntity<?> addCompany(@ModelAttribute CompanyDto companyDto, @RequestParam("image") MultipartFile file ) throws IOException {
        companyDto.setCompanyImg(file.getBytes());
        Map<String, Object> mapResponse = new HashMap<>();

        mapResponse.put("data", "");

        if (!companyDto.getCompanyName().isEmpty() && companyDto.getCompanyImg() != null &&
                !companyDto.getCompanyAddress().isEmpty() ) {
            boolean flagSave = klobServices.saveCompany(companyDto);
            if (flagSave) {
                mapResponse.put("message", flagSave);
                return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
            } else {
                mapResponse.put("message", flagSave);
                return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);
            }
        }else{
        mapResponse.put("message", "field is empty.!");
        return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);
    }
    }

    @PostMapping(value = "/new-education")
    public ResponseEntity<?> addEducation(@ModelAttribute EducationDto educationDto, @RequestParam("image") MultipartFile file ) throws IOException {
        educationDto.setEducationImg(file.getBytes());
        Map<String, Object> mapResponse = new HashMap<>();

        mapResponse.put("data", "");

        if (!educationDto.getEducationName().isEmpty() && educationDto.getEducationImg() != null) {
            boolean flagSave = klobServices.saveEducation(educationDto);
            if (flagSave) {
                mapResponse.put("message", flagSave);
                return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
            } else {
                mapResponse.put("message", flagSave);
                return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);
            }

        }else{
                mapResponse.put("message", "field is empty.!");
                return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/update-education")
    public ResponseEntity<?> updateEducation(@ModelAttribute EducationDto educationDto, @RequestParam("img") MultipartFile file)throws IOException {
        educationDto.setEducationImg(file.getBytes());
        Map<String, Object> mapResponse = new HashMap<>();

        mapResponse.put("data", "");

        if (!educationDto.getEducationName().isEmpty() && educationDto.getEducationImg() != null){
            boolean flagUpdate = klobServices.updateEducation(educationDto);
            if (flagUpdate) {
                mapResponse.put("message", flagUpdate);
                return new ResponseEntity<>(mapResponse, HttpStatus.OK);
            } else {
                mapResponse.put("message", flagUpdate);
                return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);
            }
        }else{
            mapResponse.put("message", "field is empty.!");
            return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-community")
    public ResponseEntity<?> updateCommunity(@ModelAttribute CommunityDto communityDto, @RequestParam("img") MultipartFile file)throws IOException {
        communityDto.setCommunityImg(file.getBytes());
        Map<String, Object> mapResponse = new HashMap<>();

        mapResponse.put("data", "");

        if (!communityDto.getCommunityName().isEmpty() && communityDto.getCommunityImg() != null) {
            boolean flagUpdate = klobServices.updateCommunity(communityDto);
            if (flagUpdate) {
                mapResponse.put("message", flagUpdate);
                return new ResponseEntity<>(mapResponse, HttpStatus.OK);
            } else {
                mapResponse.put("message", flagUpdate);
                return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);
            }
        } else {
            mapResponse.put("message", "field is empty.!");
            return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);
        }
    }
        @PutMapping("/update-company")
        public ResponseEntity<?> updateCompany(@ModelAttribute CompanyDto companyDto, @RequestParam("img") MultipartFile file)throws IOException {
            companyDto.setCompanyImg(file.getBytes());
            Map<String, Object> mapResponse = new HashMap<>();

            mapResponse.put("data", "");

            if (!companyDto.getCompanyName().isEmpty() && companyDto.getCompanyImg() != null &&
                    !companyDto.getCompanyAddress().isEmpty() ){
                boolean flagUpdate = klobServices.updateCompany(companyDto);
                if (flagUpdate) {
                    mapResponse.put("message", flagUpdate);
                    return new ResponseEntity<>(mapResponse, HttpStatus.OK);
                } else {
                    mapResponse.put("message", flagUpdate);
                    return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);
                }
            }else{
                mapResponse.put("message", "field is empty.!");
                return new ResponseEntity<>(mapResponse, HttpStatus.BAD_REQUEST);
            }
    }

    @DeleteMapping("/delete-company/{idCompany}")
    public ResponseEntity<?> deleteCompanyById(@PathVariable("idCompany") String idCompany){
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("data", "");
        mapResponse.put("message", true);
        klobServices.deleteCompanyById(idCompany);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
    @DeleteMapping("/delete-community/{idCommunity}")
    public ResponseEntity<?> deleteCommunityById(@PathVariable("idCommunity") String idCommunity){
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("data", "");
        mapResponse.put("message", true);
        klobServices.deleteCommunityById(idCommunity);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
    @DeleteMapping("/delete-education/{idEducation}")
    public ResponseEntity<?> deleteEducationById(@PathVariable("idEducation") String idEducation){
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("data", "");
        mapResponse.put("message", true);
        klobServices.deleteEducationById(idEducation);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
    @GetMapping("/education-list")
    public ResponseEntity<?> getAllEducation(){
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("data", klobServices.findAllEducation());
        mapResponse.put("message", true);
        return new ResponseEntity<>(mapResponse,HttpStatus.OK);
    }
    @GetMapping("/company-list")
    public ResponseEntity<?> getAllCompany(){
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("data", klobServices.findAllCompany());
        mapResponse.put("message", true);
        return new ResponseEntity<>(mapResponse,HttpStatus.OK);
    }
    @GetMapping("/community-list")
    public ResponseEntity<?> getAllCommunity(){
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("data", klobServices.findAllCommunity());
        mapResponse.put("message", true);
        return new ResponseEntity<>(mapResponse,HttpStatus.OK);
    }
    @GetMapping("/community/")
    public ResponseEntity<?> getCommunityById(@RequestParam("community_id") String idCommunity){
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("data", klobServices.findByCommunityById(idCommunity));
        mapResponse.put("message", true);
        return new ResponseEntity<>(mapResponse,HttpStatus.OK);
    }
    @GetMapping("/education/")
    public ResponseEntity<?> getEducationById(@RequestParam("education_id") String idEducation){
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("data", klobServices.findByEducationById(idEducation));
        mapResponse.put("message", true);
        return new ResponseEntity<>(mapResponse,HttpStatus.OK);
    }
    @GetMapping("/company/")
    public ResponseEntity<?> getCompanyById(@RequestParam("company_id") String idCompany){
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("data", klobServices.findByCompanyById(idCompany));
        mapResponse.put("message", true);
        return new ResponseEntity<>(mapResponse,HttpStatus.OK);
    }
}
