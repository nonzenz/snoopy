package com.uvalimised.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.uvalimised.data.Candidate;
import com.uvalimised.service.CandidateService;

public class CandidateServiceImpl implements CandidateService{
	private List<Candidate> candidates = Collections.synchronizedList(new ArrayList<Candidate>());
	
	public CandidateServiceImpl(){
		
	}
	
	public List<Candidate> getCandidates() {
		return candidates;
	}

	public Candidate getCandidate(Long id) {
		Candidate matchingCandidate = null;
		Candidate returnCandidate = null;

		synchronized (candidates) {
			for (Candidate candidate : candidates) {
				if (candidate.getId().equals(id)) {
					matchingCandidate = candidate;
					break;
				}
			}
			// --create shallow copy of the Candidate object
			if (matchingCandidate != null) {
				returnCandidate = new Candidate();
				returnCandidate.setFirstName(matchingCandidate.getFirstName());
				returnCandidate.setLastName(matchingCandidate.getLastName());
				returnCandidate.setParty(matchingCandidate.getParty());
				returnCandidate.setLocation(matchingCandidate.getLocation());
			}
		}
		return returnCandidate;
	}

	public void addCandidate(Candidate candidate) {
		candidates.add(candidate);
	}

	public boolean isUniqueID(Long id) {
		boolean isUnique = true;
		for(Candidate candidate : candidates) {
			if(candidate.getId().equals(id)) {
				isUnique = false;
				break;
			}
		}
		return isUnique;
	}

	public void removeCandidate(Long id) {
		synchronized(candidates) {
			candidates.remove(getCandidate(id));
		}
	}

	public void editCandidate(Candidate candidate) {
		Long id = candidate.getId();
		Candidate matchingCandidate = null;
		
		synchronized (candidates) {
			for (Candidate cand : candidates) {
				if (cand.getId().equals(id)) {
					matchingCandidate = cand;
					break;
				}
			}
			candidates.remove(matchingCandidate);
			candidates.add(candidate);
		}
	}

}
