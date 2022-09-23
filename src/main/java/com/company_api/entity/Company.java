package com.company_api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="company")
@Setter
@Getter
public class Company {
    @Id
    @Column(name = "company_id")
    private String companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_address")
    private String companyAddress;

    @Column(name="company_img")
    private byte[] companyImg;

    @Column(name = "company_phone")
    private String companyPhone;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
