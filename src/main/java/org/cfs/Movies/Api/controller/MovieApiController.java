package org.cfs.Movies.Api.controller;


import org.cfs.Movies.Api.entity.MovieApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.DescriptorKey;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;

@RestController
@RequestMapping("/movies")
public class MovieApiController {

    Map<Long,MovieApi> movieDB = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<MovieApi>> getAllMovie(){
        return ResponseEntity.ok(new ArrayList<>(movieDB.values()));
    }

    @PostMapping
    public ResponseEntity<MovieApi> addMovie(@RequestBody MovieApi movieApi){
        movieDB.put(movieApi.getId(),movieApi);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieApi);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieApi> fetchMovieDetails(@PathVariable Long id){
        MovieApi movie = movieDB.get(id);
        if(movie==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieApi> editDetails(@PathVariable Long id, @RequestBody MovieApi movie){
        MovieApi existing = movieDB.get(id);
        if(existing==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        movieDB.put(id,movie);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieApi> deleteMovie(@PathVariable Long id){
        MovieApi existing = movieDB.get(id);
        if(existing==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        movieDB.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
