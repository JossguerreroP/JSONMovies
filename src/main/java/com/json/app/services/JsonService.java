package com.json.app.services;


import java.util.List;

import com.json.app.domain.MovieEntity;
import com.json.app.web.model.MovieDTO;


public interface JsonService {
	MovieEntity newMovie(MovieDTO movie);
	List<MovieDTO> getAll();
	void delete(MovieDTO dto);
}
