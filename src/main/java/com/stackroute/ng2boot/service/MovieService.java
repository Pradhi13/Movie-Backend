package com.stackroute.ng2boot.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;
//@Test
//public void saveMovie() throws Exception {
//  Movie movie1 = new Movie();
//  movie1.setImdbID("imdb1");
//  movie1.setTitle("Meter");
//  movie1.setYear("2015");
//  movie1.setPoster("meter.jpg");
//  String expectedJsonResponse="{\n" +
//          "  \"message\": \"Movie updated successsfully\"\n" +
//          "}";
//  when(movieService.saveMovie(movie1)).thenReturn(movie1);
//  mockMvc.perform(post("/v1/api/movie")
//          .contentType(MediaType.APPLICATION_JSON_UTF8)
//          .content(asJsonString(movie1))
//          .accept(MediaType.APPLICATION_JSON))
//          .andExpect(status().isOk())
//          .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//  		.andExpect(content().json(expectedJsonResponse));
//  verify(movieService, times(1)).saveMovie(movie1);
//  verifyNoMoreInteractions(movieService);
//	    }
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.repository.MovieRepository;

@Service
public class MovieService implements MovieServiceInterface {
	
	@Autowired
	MovieRepository movieRepository;
	
	
	
	
//	@Autowired
//	public void setMovieRepository(MovieRepository movieRepository)
//	{
//		this.movieRepository=movieRepository;
//	}
	
	
	public Iterable<Movie> listAllMovies() {
		
		
//		ObjectMapper om = new ObjectMapper();
//		ArrayList<Movie> al = new ArrayList<Movie>();
//		
//		File file = new File("./src/main/resources/json/movie.json");
//		
//	
//			Movie[] mo;
//			try {
//				mo = om.readValue(file,Movie[].class);
//				//al = (ArrayList<Movie>) Arrays.asList(mo);
//				for(Movie m:mo)
//				{
//					al.add(m);
//				}
//				
//			} catch (JsonParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JsonMappingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		System.out.println("service spring");
		
			return movieRepository.findAll();
		
	}

	public Movie getMovieById(String string) {
		
		return movieRepository.findOne(string);
		}

	public Movie saveMovie(Movie movie2) {
		//Movie movie2 = new Movie();
		
		movieRepository.save(movie2);
		return movie2;
		// TODO Auto-generated method stub
		
	}

	public void deleteMovie(String string) {
		
		 movieRepository.delete(string);
		 
		// TODO Auto-generated method stub
		
	}
	
	public void updateMovie(String s,Movie id) {
		movieRepository.save(id);
	}

	
	
	

}
