package com.json.app.web.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
	
		private boolean adult;
	    private String backdrop_path;
	    private List<Integer> genre_ids;
	    private int id;
	    private String original_language;
	    private String original_title;
	    private String overview;
	    private double popularity;
	    private String poster_path;
	    private String release_date;
	    private String title;
	    private boolean video;
	    private double vote_average;
	    private int vote_count;

}
