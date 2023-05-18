package org.mno.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.mno.entity.Candidate;
import org.mno.repo.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateServiceInterface{
	
	@Autowired
	private CandidateRepo crepo;

	@Override
	public Candidate search(Integer Id) {
		return crepo.findById(Id).get();
	}

	@Override
	public List<Candidate> candidateAll() {
		return crepo.findAll();
	}

	@Override
	public List<Candidate> sortById() {
		List<Candidate> lst=crepo.findAll();
		Collections.sort(lst,new MyComparator1());
		return lst;
	}
	@Override
	public List<Candidate> sortByName() {
		List<Candidate> lst=crepo.findAll();
		Collections.sort(lst,new MyComparator2());
		return lst;
	}

	@Override
	public Candidate edit(Integer Id) {
		return crepo.findById(Id).get();
	}

	@Override
	public String update(Candidate c) {
		crepo.save(c);
		return "Candidate "+c.getId()+" updated";
	}

	@Override
	public List<Candidate> pageList(Integer x) {
		int pageSize=10;
		Pageable p=PageRequest.of(x, pageSize);
		Page<Candidate> can=crepo.findAll(p);
		List<Candidate> clist=can.getContent();
		return clist;
	}

}

class MyComparator1 implements Comparator<Candidate>{

	@Override
	public int compare(Candidate c1, Candidate c2) {
		Integer id1=c1.getId();
		Integer id2=c2.getId();
			return id1-id2;
	}
	
}
class MyComparator2 implements Comparator<Candidate>{

	@Override
	public int compare(Candidate c1, Candidate c2) {
		String name1=c1.getCandidate_Name();
		String name2=c2.getCandidate_Name();
			return name1.compareTo(name2);
	}
}
	