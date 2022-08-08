package com.github.wesleyav.cloudparking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerIT {

	@org.springframework.boot.test.web.server.LocalServerPort

	@LocalServerPort
	private int randomPort;

	@BeforeEach
	public void SetUpTest() {
		RestAssured.port = randomPort;
		System.out.println(randomPort);

	}

	@Test
	void findAll() {

	}

	@Test
	void create() {

	}

}
