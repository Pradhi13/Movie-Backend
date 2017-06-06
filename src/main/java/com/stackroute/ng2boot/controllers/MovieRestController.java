package com.stackroute.ng2boot.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.Link;
//import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import com.stackroute.ng2boot.controllers.assembler.HateoasLinkAssembler;
import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.service.MovieService;
import com.stackroute.ng2boot.service.MovieServiceInterface;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.*;
//import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("v1/api/movie")
//@Api(value="moviecruiser", description="Operations pertaining to the Movie Cruiser App")
public class MovieRestController {
	
	
//		@ApiOperation(value = "View a list of available movies",response = Iterable.class)
//		@ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//            }
//			)
	 
	 Movie movie1 = new Movie();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private MovieServiceInterface si;
    
    @Autowired
    HateoasLinkAssembler hla;
   
    
    
    @Autowired
    public void setMovieServiceInterface(MovieServiceInterface s)
    {
    this.si=s;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="", method = RequestMethod.GET)
    //@ApiOperation(value = "List All Movies",response = Movie.class)
    public Iterable<Movie> ListMovie()
    {
    	
    	List<Movie> allMovies=(List<Movie>) si.listAllMovies();
    	hla.AssembleMovie(allMovies);
    	
    	
    	return allMovies;
    		
   }
    	
   
   


	


	@RequestMapping(value="{id}",method = RequestMethod.GET)
    //@ApiOperation(value = "get Movies based on ID",response = Movie.class)
    public ResponseEntity getMovie(@PathVariable String id)
    {
    	
    	Movie movie = si.getMovieById(id);
    	return new ResponseEntity(movie,HttpStatus.OK);
    	
    	//movie.addLink("http://localhost:8080/v1/api/movie","self");
    	
    }
    
    
    //@ApiOperation(value = "update Movies based on ID",response = Movie.class)
	 @CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(value="",method=RequestMethod.POST)
    public ResponseEntity saveMovie(@RequestBody Movie movie )
    {
    		
    	    Movie m = si.saveMovie(movie);
    	    return new ResponseEntity(m,HttpStatus.OK);
    }
    
    
    
    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public ResponseEntity deleteMovie(@PathVariable String id)
    {
    	si.deleteMovie(id);
    	Map msgMap = new HashMap<String,String>();
        msgMap.put("message","Movie deleted successsfully");
        return new ResponseEntity<Map<String,String>>(msgMap, HttpStatus.OK);

    }
    
    //@ApiOperation(value = "Update a movie")
    @RequestMapping(value="{id}",method=RequestMethod.PUT)
      public ResponseEntity updateMovie(@PathVariable String id, @RequestBody Movie movie)
    	{
    	si.updateMovie(id,movie);
    	Map msgMap = new HashMap<String,String>();
        msgMap.put("message","Movie updated successsfully");
        return new ResponseEntity<Map<String,String>>(msgMap, HttpStatus.OK);
    
    	}
    
    
    
}
   
    
    
//
//
//    public @ResponseBody  Iterable<Movie>  list() {
//
//    }
//
//    @ApiOperation(value = "Search a movie with an ID",response = Movie.class)
//
//    public Movie getMovie(@PathVariable String id, Model model){
//
//    }
//
//    @ApiOperation(value = "Add a movie")
//
//    public ResponseEntity saveMovie(@RequestBody Movie movie){
//    	
//    }
//
//    @ApiOperation(value = "Update a movie")
//
//    public ResponseEntity updateMovie(@PathVariable String id, @RequestBody Movie movie){
//
//    }
//
//    @ApiOperation(value = "Delete a movie")
//
//    public ResponseEntity deleteMovie(@PathVariable String id){
//
//    }}
