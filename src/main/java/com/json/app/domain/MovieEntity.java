package com.json.app.domain;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity {
	@Id
    private int id; // This is the primary key
    private boolean adult;
    private String backdrop_path;
    @ElementCollection
    private List<Integer> genre_ids;
    private String original_language;
    private String original_title;
    @Column(length = 2000) // to allow long descriptions
    private String overview;
    private double popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;
}
