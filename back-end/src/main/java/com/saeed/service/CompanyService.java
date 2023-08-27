package com.saeed.service;

import com.saeed.dto.CompanyDTO;
import com.saeed.enums.CategoryEnum;

import java.util.List;

public interface CompanyService {

	List<CompanyDTO> getAllCompany();

	List<CompanyDTO> findByCategoryEnum(CategoryEnum categoryEnum);

	CompanyDTO getCompanyById(Long id);

	CompanyDTO createCompany(CompanyDTO companyDTO);

	CompanyDTO updateCompany(Long id, CompanyDTO companyDTO);

	void deleteCompany(Long id);

	void deleteAllCompany();
}
