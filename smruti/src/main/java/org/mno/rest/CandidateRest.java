package org.mno.rest;

import java.util.List;

import org.mno.entity.Candidate;
import org.mno.service.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateRest {

	@Autowired
	private CandidateServiceInterface service;
	
	@GetMapping("/search/{Id}")
	public Candidate search(@PathVariable Integer Id) {
		return service.search(Id);
	}
	
	@GetMapping("/all")
	public List<Candidate> all() {
		return service.candidateAll();
	}
	
	@GetMapping("/sortById")
	public List<Candidate> sortAll() {
		return service.sortById();
	}
	@GetMapping("/sortByName")
	public List<Candidate> sortByName() {
		return service.sortByName();
	}
	
	@GetMapping("/edit/{Id}")
	public Candidate edit(@PathVariable Integer Id) {
		return service.edit(Id);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Candidate c) {
		return service.update(c);
	}	
	
	@GetMapping("/page/{x}")
	public List<Candidate> update(@PathVariable Integer x) {
		return service.pageList(x);
	}
}
