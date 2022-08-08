package com.github.wesleyav.cloudparking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wesleyav.cloudparking.controller.dto.ParkingDTO;
import com.github.wesleyav.cloudparking.controller.mapper.ParkingMapper;
import com.github.wesleyav.cloudparking.model.Parking;
import com.github.wesleyav.cloudparking.service.ParkingService;

@RestController
@RequestMapping(value = "/parking")
public class ParkingController {

	private final ParkingService parkingService;
	private final ParkingMapper parkingMapper;

	public ParkingController(ParkingService parkingService) {
		this.parkingService = parkingService;
		this.parkingMapper = new ParkingMapper();
	}

	@GetMapping
	public List<ParkingDTO> findAll() {

		List<Parking> parkingList = parkingService.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
	}

}
