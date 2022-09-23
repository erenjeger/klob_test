package com.company_api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class EducationDto {
    private String educationId;
    private String educationName;
    private byte[] educationImg;
}
