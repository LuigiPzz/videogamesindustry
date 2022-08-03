package com.videogamescollections.lp.UnitTest.RepositoryTest;

import static org.assertj.core.api.Assertions.extractProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.videogamescollections.lp.VideogamesCollectionApplication;
import com.videogamescollections.lp.model.Console;
import com.videogamescollections.lp.model.Videogame;
import com.videogamescollections.lp.repository.IVideogameRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = VideogamesCollectionApplication.class)
@SpringBootTest
public class VideogameRepositoryTest {
	
	@Autowired
	private IVideogameRepository ivideogamerepository;
	
	@Test
	public void TestSearchVideogamesByTitle() {
		List<Videogame> items = ivideogamerepository.findByTitoloContaining("Alice Madness Return");
		assertEquals(1, items.size());
	}
	
	@Test
	public void TestFindVideogameById() {
		Optional<Videogame> items = ivideogamerepository.findById(5);
		Videogame videogame = items.get();
		videogame.equals("Alan Wake");
	
	}

}
