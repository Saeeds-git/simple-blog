package com.saeed.service;

import com.saeed.dto.AdvertisementDTO;
import com.saeed.enums.JobEnum;

import java.util.List;

public interface AdvertisementService {

	AdvertisementDTO createAdvertisement(AdvertisementDTO advertisementDTO);

	List<AdvertisementDTO> getAllAdvertisement();

	List<AdvertisementDTO> findByJobEnum(JobEnum jobEnum);

	AdvertisementDTO getAdvertisementById(Long id);

	AdvertisementDTO updateAdvertisement(Long id, AdvertisementDTO advertisementDTO);

	void deleteAdvertisement(Long id);

	void deleteAllAdvertisement();
}
