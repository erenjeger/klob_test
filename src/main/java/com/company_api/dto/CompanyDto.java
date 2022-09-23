package com.company_api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CompanyDto {
    private String companyId;
    private String companyName;
    private String companyAddress;
    private byte[] companyImg;
    private String companyPhone;
}
