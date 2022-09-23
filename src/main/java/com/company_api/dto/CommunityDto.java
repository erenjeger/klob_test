package com.company_api.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class CommunityDto {
    private String communityId;
    private String communityName;
    private byte[] communityImg;
}
