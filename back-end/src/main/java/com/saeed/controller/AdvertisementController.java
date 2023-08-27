package com.saeed.controller;

import com.saeed.dto.AdvertisementDTO;
import com.saeed.enums.JobEnum;
import com.saeed.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdvertisementController {

	@Autowired
	AdvertisementService advertisementService;

	@PostMapping("/advertisement")
	public ResponseEntity<AdvertisementDTO> createAdvertisement(@RequestBody AdvertisementDTO advertisementDTO) {
		AdvertisementDTO createdAdvertisementDTO = advertisementService.createAdvertisement(advertisementDTO);
		return new ResponseEntity<>(createdAdvertisementDTO, HttpStatus.CREATED);
	}

	@GetMapping("/advertisement")
	public ResponseEntity<List<AdvertisementDTO>> getAllAdvertisement() {

		List<AdvertisementDTO> advertisementDTOList = advertisementService.getAllAdvertisement();
		if (advertisementDTOList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(advertisementDTOList, HttpStatus.OK);
	}

	@GetMapping("/advertisement/category")
	public ResponseEntity<List<AdvertisementDTO>> findByJobEnum(JobEnum jobEnum) {

		List<AdvertisementDTO> advertisementDTOList = advertisementService.findByJobEnum(jobEnum);
		if (advertisementDTOList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(advertisementDTOList, HttpStatus.OK);
	}

	@GetMapping("/advertisement/{id}")
	public ResponseEntity<AdvertisementDTO> getAdvertisementById(@PathVariable("id") Long id) {

		AdvertisementDTO advertisementDTO = advertisementService.getAdvertisementById(id);
		return new ResponseEntity<>(advertisementDTO, HttpStatus.OK);
	}

	@PutMapping("/advertisement/{id}")
	public ResponseEntity<AdvertisementDTO> updateAdvertisement(@PathVariable("id") Long id, @RequestBody AdvertisementDTO advertisementDTO) {

		AdvertisementDTO advertisementDTOAfterUpdate = advertisementService.updateAdvertisement(id, advertisementDTO);

		if (advertisementDTOAfterUpdate != null) {
			return new ResponseEntity<>(advertisementDTOAfterUpdate, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/advertisement/{id}")
	public ResponseEntity<HttpStatus> deleteAdvertisement(@PathVariable("id") Long id) {
		advertisementService.deleteAdvertisement(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/advertisement")
	public ResponseEntity<HttpStatus> deleteAllAdvertisement() {
		try {
			advertisementService.deleteAllAdvertisement();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
