package com.Sample.IPLProject;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.TournamentService;
import com.model.Tournaments;

import junit.framework.Assert;

@SpringBootTest
class TournamentTest1 {

	@Autowired
	TournamentService tourService;

	@Test
	void testAdd() {
		Tournaments tournaments=new Tournaments();
		tournaments.setNumOfTeams(5);
		String str ="2022-08-01";
		Date d = Date.valueOf(str);
		
		tournaments.setDuration(d);
		tourService.add(tournaments);
		
		Tournaments to_be_tested = tourService.findItem(tournaments.getTournamentid());
		Assert.assertEquals(5, to_be_tested.getNumOfTeams());
		Assert.assertEquals(Date.valueOf("2022-08-01"), to_be_tested.getDuration());
	}

	@Test
	void testFindItem() {
		Tournaments tournaments=new Tournaments();
		tournaments.setNumOfTeams(8);
		tournaments.setDuration(Date.valueOf("2022-03-05"));
		tourService.add(tournaments);
		
		Tournaments to_be_tested = tourService.findItem(tournaments.getTournamentid());
		Assert.assertEquals(8, to_be_tested.getNumOfTeams());
		Assert.assertEquals(Date.valueOf("2022-03-05"), to_be_tested.getDuration());
	}

	@Test
	void testFindAllTeam() {
		
		Tournaments tournaments=new Tournaments();
		tournaments.setNumOfTeams(5);
		String str="2022-04-06";
		Date d = Date.valueOf(str);
		tournaments.setDuration(d);
		tourService.add(tournaments);
		
		Tournaments tournaments1=new Tournaments();
		tournaments1.setNumOfTeams(8);
		String str1="2022-03-04";
		Date d1 = Date.valueOf(str1);
		tournaments1.setDuration(d1);
		tourService.add(tournaments1);
		
		List<Tournaments> tourlist =tourService.findAllTeam();
		
		Assert.assertEquals(tourlist.get(1).getNumOfTeams(),5 );
		Assert.assertEquals(tourlist.get(2).getDuration(),Date.valueOf("2022-03-04"));
	}

	@Test
	void testUpdate() {
		Tournaments tournaments1=new Tournaments();
		tournaments1.setNumOfTeams(10);
		tournaments1.setDuration(Date.valueOf("2022-01-01"));
		tourService.add(tournaments1);
		tournaments1.setTournamentid(4);
		tourService.update(tournaments1);
		
		//Tournaments to_be_tested = tourService.findItem(tournaments1.getTournamentid());
		Assert.assertEquals(true, tourService.update(tournaments1));
	}

	@Test
	void testDelete() {
		
		Tournaments tournaments2=tourService.findItem(3);
		tourService.delete(tournaments2.getTournamentid());
		Tournaments tournaments3 = tourService.findItem(3);
		
		Assert.assertNull(tournaments3);
	}
}
