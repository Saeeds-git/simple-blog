package com.saeed.service.impl;

import com.saeed.dto.CompanyDTO;
import com.saeed.entity.CompanyEntity;
import com.saeed.enums.CategoryEnum;
import com.saeed.mapper.CompanyMapper;
import com.saeed.repository.CompanyRepository;
import com.saeed.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	CompanyMapper companyMapper;

	@Override
	public List<CompanyDTO> getAllCompany() {

		return companyMapper.entityToDTOList(companyRepository.findAll());
	}

	@Override
	public List<CompanyDTO> findByCategoryEnum(CategoryEnum categoryEnum) {

		List<CompanyEntity> companyEntityList = companyRepository.findByCategoryEnum(categoryEnum);
		return companyMapper.entityToDTOList(companyEntityList);
	}

	@Override
	public CompanyDTO getCompanyById(Long id) {

		Optional<CompanyEntity> optionalArticleEntity = companyRepository.findById(id);

		if (!optionalArticleEntity.isPresent()) {
			return null;
		}

		CompanyEntity companyEntity = optionalArticleEntity.get();

		return companyMapper.entityToDTO(companyEntity);
	}

	@Override
	public CompanyDTO createCompany(CompanyDTO companyDTO) {

		CompanyEntity companyEntityBeforeSave = companyMapper.dtoToEntity(companyDTO);

		CompanyEntity companyEntityAfterSave = companyRepository.save(companyEntityBeforeSave);

		return companyMapper.entityToDTO(companyEntityAfterSave);
	}

	@Override
	public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {

		Optional<CompanyEntity> optionalArticleEntity = companyRepository.findById(id);

		if (optionalArticleEntity.isPresent()) {
			CompanyEntity companyEntity = optionalArticleEntity.get();
			companyEntity.setName(companyDTO.getName());
			companyEntity.setAddress(companyDTO.getAddress());
			companyEntity.setStartYear(companyDTO.getStartYear());
			companyEntity.setRegion(companyDTO.getRegion());
			companyEntity.setTechStack(companyDTO.getTechStack());
			companyEntity.setCategoryEnum(companyDTO.getCategoryEnum());
			companyEntity.setDescription(companyDTO.getDescription());
			CompanyEntity companyEntityBeforeSave = companyRepository.save(companyEntity);
			return companyMapper.entityToDTO(companyEntityBeforeSave);
		}
		return null;
	}

	@Override
	public void deleteCompany(Long id) {
		companyRepository.deleteById(id);
	}

	@Override
	public void deleteAllCompany() {
		companyRepository.deleteAll();
	}
}
