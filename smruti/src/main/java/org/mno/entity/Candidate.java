package org.mno.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Candidate {

	@Id
	private Integer Id;
	private String Candidate_Name; 
	private Long Candidate_Phone_Number; 
	private String Candidate_Email;
	private String Address;

}
