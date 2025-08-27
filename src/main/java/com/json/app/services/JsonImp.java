package com.json.app.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.json.app.domain.MovieEntity;
import com.json.app.repository.MovieRepository;
import com.json.app.web.mapper.MovieMapper;
import com.json.app.web.model.MovieDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;




@RequiredArgsConstructor
@Service
public class JsonImp implements JsonService{
	
	
	private final MovieRepository movieRepository;
	private final MovieMapper movieMapper;
	
	@Override
	public MovieEntity newMovie(MovieDTO dto) {
		MovieEntity entity = movieMapper.movieDTOtoMovieEntity(dto);
		return this.movieRepository.save(entity);
	}

	@Override
	@Transactional
	public List<MovieDTO> getAll() {
		// TODO Auto-generated method stub
		 return this.movieRepository.findAll().stream()
				.map(movieMapper::movieEntitytoMovieDTO)
				 .collect(Collectors.toList());
	}



}
