package org.mno.service;

import java.util.List;

import org.mno.entity.Candidate;

public interface CandidateServiceInterface {
	
	public Candidate search(Integer Id);
	public List<Candidate> candidateAll();
	public List<Candidate> sortById();
	public List<Candidate> sortByName();
	//pagination of the grid
	public Candidate edit(Integer Id);
	public String update(Candidate c);
	public List<Candidate> pageList(Integer x);

}
