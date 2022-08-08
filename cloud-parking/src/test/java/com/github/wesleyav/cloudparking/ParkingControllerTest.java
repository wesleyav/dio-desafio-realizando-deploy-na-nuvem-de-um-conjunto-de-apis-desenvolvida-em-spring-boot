package com.github.wesleyav.cloudparking;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.github.wesleyav.cloudparking.controller.dto.ParkingCreateDTO;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingControllerTest extends AbstractContainerBase {

	@org.springframework.boot.test.web.server.LocalServerPort

	@LocalServerPort
	private int randomPort;

	@BeforeEach
	public void SetUpTest() {
		RestAssured.port = randomPort;
		System.out.println(randomPort);

	}

	@Test
	void whenFindAllThenCheckResult() {
		RestAssured.given()
		.when()
		.get("/parking")
		.then()
		.statusCode(HttpStatus.OK.value());
	}

	@Test
	void whenCreateThenCheckIsCreated() {
		
		ParkingCreateDTO createDTO = new ParkingCreateDTO();
		createDTO.setColor("AMERELO");
		createDTO.setLicense("WRT-5555");
		createDTO.setModel("BRASILIA");
		createDTO.setState("SP");
		
		RestAssured.given()
		.when()
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.body(createDTO)
		.post("/parking")
		.then()
		.statusCode(HttpStatus.CREATED.value())
		.body("license", Matchers.equalTo("WRT-5555"))
		.body("color", Matchers.equalTo("AMARELO"));
		
		

	}

}
