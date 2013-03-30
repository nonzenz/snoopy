package com.uvalimised.service;

import java.util.List;

import com.uvalimised.data.Candidate;

/**
 * Candidate interface
 * Implementation is @CandidateServiceImpl
 * @Author Robert Väljur
 */
public interface CandidateService {
	
	/**
	 * Get list of candidates
	 * @return list of candidates
	 */
	List<Candidate> getCandidates();
	
	/**
	 * Get a candidate
	 * @param id - ID of the candidate
	 * @return Candidate
	 */
	Candidate getCandidate(Long id);
	
	/**
	 * Add a Candidate
	 * @param candidate - Candidate to be added
	 */
	void addCandidate(Candidate candidate);
	
	/**
	 * Check if Candidate ID is unique
	 * @param id - id of the Candidate to be checked out
	 * @return true, if Candidate ID is unique
	 */
	boolean isUniqueID(Long id);
	
	/**
	 * remove Candidate
	 * @param id - Candidate ID
	 */
	void removeCandidate(Long id);
	
	/**
	 * Update candidate properties
	 * 
	 * @param candidate  - the modified Candidate
	 */
	void editCandidate(Candidate candidate);
}
