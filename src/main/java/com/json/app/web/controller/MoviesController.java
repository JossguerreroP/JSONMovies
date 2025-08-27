package com.json.app.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.json.app.services.JsonService;
import com.json.app.web.model.MovieResponse;



@RequestMapping("/movies")
@RestController

public class MoviesController {
	
	private final JsonService jsonService;
	private final MovieResponse movieresponse;
	
	
	public void setMovieRes() {
	    this.movieresponse.setPage(1);
	    this.movieresponse.setTotal_pages(52111);
	    this.movieresponse.setTotal_results(1042219);
	}
	
	public MoviesController(JsonService jsonService) {
		this.jsonService = jsonService;
		 this.movieresponse = new MovieResponse();
		setMovieRes();
	}
	
	@GetMapping
    public ResponseEntity<MovieResponse> getAllProducts() {
		this.movieresponse.setResults(this.jsonService.getAll());
        return new ResponseEntity<>(this.movieresponse, HttpStatus.OK);
        
    }

}
