package com.stackroute.ng2boot.service;

import java.util.ArrayList;

import com.stackroute.ng2boot.domain.Movie;

public interface MovieServiceInterface {
	
	public Iterable<Movie> listAllMovies();
	public Movie getMovieById(String a);
	public Movie saveMovie(Movie movie1);
	public void deleteMovie(String string);
	public void updateMovie(String id, Movie movie);

}
