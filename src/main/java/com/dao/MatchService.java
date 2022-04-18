package com.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



import com.model.Match;

@Service
public class MatchService {

		@Autowired
		MatchDAO matchdaoimpl;
		
		public void add(Match match) {
			matchdaoimpl.addTeam(match);
		}
		
		public Match findItem(int id) {
			return matchdaoimpl.findteam(id);
		}
		
		public List<Match> findAllTeam() {
			return matchdaoimpl.findAllTeam();
		}
		
		public boolean update(Match match) {
			return matchdaoimpl.updateTeam(match);
		}
		
		public boolean delete(int id) {
			return matchdaoimpl.deleteTeam(id);
		}

}
