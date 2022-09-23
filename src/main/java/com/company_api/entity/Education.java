package com.company_api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="education")
@Setter
@Getter
public class Education {
    @Id
    @Column(name = "education_id")
    private String educationId;

    @Column(name = "education_name")
    private String educationName;

    @Column(name="education_img")
    private byte[] educationImg;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
