package com.saeed.mapper;

import com.saeed.dto.PersonDTO;
import com.saeed.entity.PersonEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	PersonDTO entityToDTO(PersonEntity personEntity);

	List<PersonDTO> entityToDTOList(List<PersonEntity> personEntityList);

	PersonEntity dtoToEntity(PersonDTO advertisementDTO);

	List<PersonEntity> dtoToEntityList(List<PersonDTO> personDTOList);

}
