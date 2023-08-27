package com.saeed.service;

import com.saeed.dto.PersonDTO;

import java.util.List;

public interface PersonService {

	PersonDTO createPerson(PersonDTO personDTO);

	List<PersonDTO> getAllPerson();
}
