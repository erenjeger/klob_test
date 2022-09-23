package com.company_api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="community")
@Setter
@Getter
public class Community {
    @Id
    @Column(name = "community_id")
    private String communityId;

    @Column(name = "community_name")
    private String communityName;

    @Column(name="community_img")
    private byte[] communityImg;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
