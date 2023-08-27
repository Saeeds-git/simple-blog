package com.saeed.controller;

import com.saeed.dto.CompanyDTO;
import com.saeed.enums.CategoryEnum;
import com.saeed.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@PostMapping("/company")
	public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO) {
		CompanyDTO createdCompanyDTO = companyService.createCompany(companyDTO);
		return new ResponseEntity<>(createdCompanyDTO, HttpStatus.CREATED);
	}

	@GetMapping("/company")
	public ResponseEntity<List<CompanyDTO>> getAllCompany() {

		List<CompanyDTO> companyDTOList = companyService.getAllCompany();
		if (companyDTOList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(companyDTOList, HttpStatus.OK);
	}

	@GetMapping("/company/category")
	public ResponseEntity<List<CompanyDTO>> findByCategoryEnum(CategoryEnum categoryEnum) {

		List<CompanyDTO> companyDTOList = companyService.findByCategoryEnum(categoryEnum);
		if (companyDTOList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(companyDTOList, HttpStatus.OK);
	}

	@GetMapping("/company/{id}")
	public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable("id") Long id) {

		CompanyDTO companyDTO = companyService.getCompanyById(id);
		return new ResponseEntity<>(companyDTO, HttpStatus.OK);
	}

	@PutMapping("/company/{id}")
	public ResponseEntity<CompanyDTO> updateCompany(@PathVariable("id") Long id, @RequestBody CompanyDTO companyDTO) {

		CompanyDTO companyDTOAfterUpdate = companyService.updateCompany(id, companyDTO);

		if (companyDTOAfterUpdate != null) {
			return new ResponseEntity<>(companyDTOAfterUpdate, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/company/{id}")
	public ResponseEntity<HttpStatus> deleteCompany(@PathVariable("id") Long id) {
		companyService.deleteCompany(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/company")
	public ResponseEntity<HttpStatus> deleteAllCompany() {
		try {
			companyService.deleteAllCompany();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
