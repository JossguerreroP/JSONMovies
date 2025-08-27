package com.json.app.repository;
import com.json.app.domain.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MovieRepository extends JpaRepository<MovieEntity, Integer>{

}
