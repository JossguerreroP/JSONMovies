package com.json.app.services;
import org.springframework.stereotype.Service;
import com.json.app.domain.MovieEntity;
import com.json.app.repository.MovieRepository;

import lombok.RequiredArgsConstructor;




@RequiredArgsConstructor
@Service
public class JsonImp implements JsonService{
	
	
	private final MovieRepository MovieRepository;
	
	@Override
	public MovieEntity newMovie(MovieEntity movie) {
		
		return MovieRepository.save(movie);
	}

}
