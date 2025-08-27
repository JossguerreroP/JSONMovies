package com.json.app.web.mapper;

import org.mapstruct.Mapper;

import com.json.app.domain.MovieEntity;
import com.json.app.web.model.MovieDTO;

@Mapper(componentModel = "spring")
public interface MovieMapper {

	MovieEntity movieDTOtoMovieEntity(MovieDTO dto);
	MovieDTO    movieEntitytoMovieDTO(MovieEntity entity);
	
}
