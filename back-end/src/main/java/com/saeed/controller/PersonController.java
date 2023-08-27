package com.saeed.controller;

import com.saeed.dto.PersonDTO;
import com.saeed.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@PostMapping("/person")
	public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
		PersonDTO createdPersonDTO = personService.createPerson(personDTO);
		return new ResponseEntity<>(createdPersonDTO, HttpStatus.CREATED);
	}

	@GetMapping("/person")
	public ResponseEntity<List<PersonDTO>> getAllPerson() {

		List<PersonDTO> personDTOList = personService.getAllPerson();
		if (personDTOList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(personDTOList, HttpStatus.OK);
	}
}
