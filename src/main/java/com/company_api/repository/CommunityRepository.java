package com.company_api.repository;

import com.company_api.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, String> {
    Community findByCommunityId(String communityId);
    List<Community> findAll();

}
