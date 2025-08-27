package com.json.app.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.json.app.domain.MovieEntity;
import com.json.app.repository.MovieRepository;



@SpringBootTest
public class JsonImpTest {
	
	@Autowired
    JsonService jsonService;

    @Autowired
    MovieRepository movieRepository;

    MovieEntity movieEntity;
    
	@BeforeEach
	void setUp() throws Exception {
		
		 
	}
	
	
	@Test
	void newMovieTest() {
	}
}
