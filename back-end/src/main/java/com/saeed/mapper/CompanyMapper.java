package com.saeed.mapper;

import com.saeed.dto.CompanyDTO;
import com.saeed.entity.CompanyEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

	CompanyDTO entityToDTO(CompanyEntity companyEntity);

	List<CompanyDTO> entityToDTOList(List<CompanyEntity> companyEntityList);

	CompanyEntity dtoToEntity(CompanyDTO companyDTO);

	List<CompanyEntity> dtoToEntityList(List<CompanyDTO> companyDTOList);

}
