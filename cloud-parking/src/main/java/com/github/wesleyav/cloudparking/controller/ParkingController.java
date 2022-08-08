package com.github.wesleyav.cloudparking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wesleyav.cloudparking.controller.dto.ParkingCreateDTO;
import com.github.wesleyav.cloudparking.controller.dto.ParkingDTO;
import com.github.wesleyav.cloudparking.controller.mapper.ParkingMapper;
import com.github.wesleyav.cloudparking.model.Parking;
import com.github.wesleyav.cloudparking.service.ParkingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/parking")
@Tag(name = "ParkingController")
public class ParkingController {

	private final ParkingService parkingService;
	private final ParkingMapper parkingMapper;

	public ParkingController(ParkingService parkingService) {
		this.parkingService = parkingService;
		this.parkingMapper = new ParkingMapper();
	}

	@GetMapping
	@Operation(summary = "Endpoint to list parkings")
	public ResponseEntity<List<ParkingDTO>> findAll() {
		List<Parking> parkingList = parkingService.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/{id}")
	@Operation(summary = "Endpoint to list parking by id")
	public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
		Parking parking = parkingService.findById(id);
		ParkingDTO result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.ok(result);
	}

	@PostMapping
	@Operation(summary = "Endpoint to create parking")
	public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {
		Parking parkingCreate = parkingMapper.toParkingCreate(dto);
		Parking parking = parkingService.create(parkingCreate);
		ParkingDTO result = parkingMapper.toParkingDTO(parking);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

}
