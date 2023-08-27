package com.saeed.service.impl;

import com.saeed.dto.AdvertisementDTO;
import com.saeed.entity.AdvertisementEntity;
import com.saeed.enums.JobEnum;
import com.saeed.mapper.AdvertisementMapper;
import com.saeed.repository.AdvertisementRepository;
import com.saeed.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

	@Autowired
	AdvertisementRepository advertisementRepository;

	@Autowired
	AdvertisementMapper advertisementMapper;

	@Override
	public AdvertisementDTO createAdvertisement(AdvertisementDTO advertisementDTO) {

		AdvertisementEntity advertisementEntityBeforeSave = advertisementMapper.dtoToEntity(advertisementDTO);

		AdvertisementEntity advertisementEntityAfterSave = advertisementRepository.save(advertisementEntityBeforeSave);

		return advertisementMapper.entityToDTO(advertisementEntityAfterSave);
	}

	@Override
	public List<AdvertisementDTO> getAllAdvertisement() {

		return advertisementMapper.entityToDTOList(advertisementRepository.findAll());
	}

	@Override
	public List<AdvertisementDTO> findByJobEnum(JobEnum jobEnum) {

		List<AdvertisementEntity> advertisementEntityList = advertisementRepository.findByJobEnum(jobEnum);
		return advertisementMapper.entityToDTOList(advertisementEntityList);
	}

	@Override
	public AdvertisementDTO getAdvertisementById(Long id) {

		Optional<AdvertisementEntity> optionalAdvertisementEntity = advertisementRepository.findById(id);

		if (!optionalAdvertisementEntity.isPresent()) {
			return null;
		}

		AdvertisementEntity advertisementEntity = optionalAdvertisementEntity.get();

		return advertisementMapper.entityToDTO(advertisementEntity);
	}

	@Override
	public AdvertisementDTO updateAdvertisement(Long id, AdvertisementDTO advertisementDTO) {

		Optional<AdvertisementEntity> optionalAdvertisementEntity = advertisementRepository.findById(id);

		if (optionalAdvertisementEntity.isPresent()) {
			AdvertisementEntity advertisementEntity = optionalAdvertisementEntity.get();
			advertisementEntity.setDescription(advertisementDTO.getDescription());
			advertisementEntity.setClosed(advertisementDTO.getClosed());
			advertisementEntity.setJobEnum(advertisementDTO.getJobEnum());
			advertisementEntity.setCompanyId(advertisementDTO.getCompanyId());
			AdvertisementEntity advertisementEntityBeforeSave = advertisementRepository.save(advertisementEntity);
			return advertisementMapper.entityToDTO(advertisementEntityBeforeSave);
		}
		return null;
	}

	@Override
	public void deleteAdvertisement(Long id) {
		advertisementRepository.deleteById(id);
	}

	@Override
	public void deleteAllAdvertisement() {
		advertisementRepository.deleteAll();
	}
}
