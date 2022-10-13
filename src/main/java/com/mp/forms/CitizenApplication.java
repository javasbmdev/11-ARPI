package com.mp.forms;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenApplication {
	private String fullName;
	private String emailId;
	private String phoneNo;
	private String gender;
	private Long ssn;
	private LocalDate dob;

}
