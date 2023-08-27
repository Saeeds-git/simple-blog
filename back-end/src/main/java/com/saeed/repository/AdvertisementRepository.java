package com.saeed.repository;

import com.saeed.entity.AdvertisementEntity;
import com.saeed.enums.JobEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, Long> {

	List<AdvertisementEntity> findByJobEnum(JobEnum jobEnum);
}
