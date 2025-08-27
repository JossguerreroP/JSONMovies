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

public class MovieResponse {
	private int page;
    private List<Movie> results;
    private int total_pages;
    private int total_results;
}
