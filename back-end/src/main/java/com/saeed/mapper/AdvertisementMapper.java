package com.saeed.mapper;

import com.saeed.dto.AdvertisementDTO;
import com.saeed.entity.AdvertisementEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdvertisementMapper {

	AdvertisementDTO entityToDTO(AdvertisementEntity advertisementEntity);

	List<AdvertisementDTO> entityToDTOList(List<AdvertisementEntity> advertisementEntityList);

	AdvertisementEntity dtoToEntity(AdvertisementDTO advertisementDTO);

	List<AdvertisementEntity> dtoToEntityList(List<AdvertisementDTO> advertisementDTOList);

}
