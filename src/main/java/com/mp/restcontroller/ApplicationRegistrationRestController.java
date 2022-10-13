package com.mp.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mp.forms.CitizenApplication;
import com.mp.services.ApplicationRegistrationServiceImpl;

@RestController
public class ApplicationRegistrationRestController {
	@Autowired
	private ApplicationRegistrationServiceImpl service;

	@PostMapping("/create-app")
	public ResponseEntity<String> crateCitizenApp(@RequestBody CitizenApplication application) {
		int status = service.crateApplication(application);
		if (status != 0) {
			return new ResponseEntity<String>("Applicaton Id :" + status, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Invalid ssn", HttpStatus.OK);
		}
	}
}
