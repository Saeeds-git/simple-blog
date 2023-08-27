package com.saeed.service.impl;

import com.saeed.dto.PersonDTO;
import com.saeed.entity.PersonEntity;
import com.saeed.mapper.PersonMapper;
import com.saeed.repository.PersonRepository;
import com.saeed.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonMapper personMapper;

	@Override
	public PersonDTO createPerson(PersonDTO personDTO) {

		PersonEntity personEntityBeforeSave = personMapper.dtoToEntity(personDTO);

		PersonEntity personEntityAfterSave = personRepository.save(personEntityBeforeSave);

		return personMapper.entityToDTO(personEntityAfterSave);
	}

	@Override
	public List<PersonDTO> getAllPerson() {
		return personMapper.entityToDTOList(personRepository.findAll());
	}
}
