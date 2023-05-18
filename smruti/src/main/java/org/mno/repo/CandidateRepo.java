package org.mno.repo;

import java.io.Serializable;

import org.mno.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate, Serializable> {

}
