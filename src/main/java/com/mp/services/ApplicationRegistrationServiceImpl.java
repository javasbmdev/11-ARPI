package com.mp.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mp.entities.CitizenApplicationEntity;
import com.mp.forms.CitizenApplication;
import com.mp.repository.CitizensApplicationRepository;
@Service
public class ApplicationRegistrationServiceImpl implements ApplicationRegistrationService {
	@Autowired
	private CitizensApplicationRepository repository;

	@Override
	public Integer crateApplication(CitizenApplication application) {

		String endPointUrl = "https://ssa-web-api.herokuapp.com/ssn/{ssn}";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(endPointUrl, String.class,
				application.getSsn());
		String state = responseEntity.getBody();
		if (state.equals("New Jersey")) {
			CitizenApplicationEntity entity = new CitizenApplicationEntity();
			BeanUtils.copyProperties(application, entity);
			entity.setStateName(state);
			entity = repository.save(entity);
			return entity. getApplicationId();
		}
		return 0;
	}

}
