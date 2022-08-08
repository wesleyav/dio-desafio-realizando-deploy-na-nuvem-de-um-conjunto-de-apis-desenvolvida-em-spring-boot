package com.github.wesleyav.cloudparking.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wesleyav.cloudparking.model.Parking;

@RestController
@RequestMapping(value = "/parking")
public class ParkingController {

	@GetMapping
	public List<Parking> findAll() {

		Parking parking = new Parking();
		parking.setColor("PRETO");
		parking.setLicense("MSS-1111");
		parking.setModel("VW GOL");
		parking.setState("SP");
		
		

		return Arrays.asList(parking);
	}

}
