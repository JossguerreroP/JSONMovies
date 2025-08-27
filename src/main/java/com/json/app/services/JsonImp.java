package com.json.app.services;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.app.domain.MovieEntity;
import com.json.app.repository.MovieRepository;
import com.json.app.web.mapper.MovieMapper;
import com.json.app.web.model.MovieDTO;
import com.json.app.web.model.MovieResponse;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;




@RequiredArgsConstructor
@Service
public class JsonImp implements JsonService{
	
	private final ObjectMapper objectMapper;
	private final MovieRepository movieRepository;
	private final MovieMapper movieMapper;
	private List<MovieDTO> listMoviesDTO;
	private Path path;
	private String json;
	
	
	public Integer checkData() {
		return this.movieRepository.findAll().size();
	}
	

	
	@Override
	public MovieEntity newMovie(MovieDTO dto) {
		MovieEntity entity = movieMapper.movieDTOtoMovieEntity(dto);
		return this.movieRepository.save(entity);
	}

	@Override
	@Transactional
	public List<MovieDTO> getAll() {
		if(this.checkData()==0) {
			System.out.print("NOOOOOOOOOOOOOOOO DATAAAAAAAAAAAAAAA");
			try {
				this.listMoviesDTO = createMovieObjects();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.print("DATAAAAAAAAAAAAAAA FOUND");
			 this.listMoviesDTO = this.movieRepository.findAll().stream()
						.map(movieMapper::movieEntitytoMovieDTO)
						 .collect(Collectors.toList());
		}
		return listMoviesDTO;
	}
	
	
	
	public List<MovieDTO> createMovieObjects() throws IOException {
			MovieResponse movres = this.DeserializeOrigin();
			List<MovieEntity> moviesEntities =movres
					.getResults()
					.stream()
					.map(movieMapper::movieDTOtoMovieEntity)
					.toList();
					movieRepository.saveAll(moviesEntities);
					return movres.getResults();
			
	}


	public void delete(MovieDTO dto) {
		MovieEntity entity = movieMapper.movieDTOtoMovieEntity(dto);
		this.movieRepository.deleteById(entity.getId());
	}
	
	
	
	 public  MovieResponse DeserializeOrigin() throws IOException {
		 	this.getJson();
	        MovieResponse movres = objectMapper.readValue(this.json, MovieResponse.class);
	        return movres;
	    }




	 public void getJson() {
				try {
					this.path = Paths.get(getClass().getClassLoader().getResource("elements.json").toURI());
			
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					 this.json = Files.readString(this.path, StandardCharsets.UTF_8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
		
	 }



}
