package com.json.app.services;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.json.app.domain.MovieEntity;
import com.json.app.repository.MovieRepository;
import com.json.app.web.model.MovieDTO;



@SpringBootTest
public class JsonImpTest {
	
	@Autowired
    JsonService jsonService;

    @Autowired
    MovieRepository movieRepository;

    MovieDTO dto;
    
	@BeforeEach
	void setUp() throws Exception {
		
		 this.dto = MovieDTO.builder()
				 .id(999)
	                .title("Test Movie DTO")
	                .overview("Testing DTO to Entity save flow.")
	                .original_language("en")
	                .release_date("2025-01-01")
	                .adult(false)
	                .backdrop_path("/testbackdrop.jpg")
	                .poster_path("/poster.jpg")
	                .video(false)
	                .vote_average(7.5)
	                .vote_count(100)
	                .popularity(123.45)
	                .genre_ids(List.of(1, 2, 3))
	                .original_title("Original Test Title")
	                .build();
	}
	
	
	@Test
	void newMovieTest() {
		MovieEntity savedMovie = jsonService.newMovie(dto);
	}
	
	@Test
	void getList() {
		List<MovieDTO>  moviesList = jsonService.getAll();
		System.out.print(moviesList);
	}
	
	@Test
	void deleteById() {
		 jsonService.delete(dto);
		
	}
	
	@Test
	void justTesting() {
		
		
	}
	
	
}
