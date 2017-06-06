package com.stackroute.ng2boot.controllers.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stackroute.ng2boot.controllers.MovieRestController;
import com.stackroute.ng2boot.domain.Movie;
import com.stackroute.ng2boot.service.MovieServiceInterface;
@Service
public class HateoasLinkAssemblerImp implements HateoasLinkAssembler{
	
	@Autowired
	MovieServiceInterface ms;
	public Iterable<Movie> AssembleMovie(List<Movie> allMovies)
    {
    	
    	
    	for(Movie m:allMovies)
    	{
    		Link selfLink = linkTo(MovieRestController.class).slash(m.getimdbid()).withSelfRel();
    		m.add(selfLink);
    		
    		Link refLink = linkTo(MovieRestController.class).slash("").withRel("All movies");
    		m.add(refLink);
    		
    		Link saveLink = linkTo(MovieRestController.class).slash("save").withRel("save");
    		m.add(saveLink);
//    		Link selfLinkupdate = linkTo(MovieRestController.class).slash(m.getImdbID()).withRel("Update");
//    		m.add(selfLink);
//	    		
//	    		List<Movie> getmovie = (List<Movie>) methodOn(MovieRestController.class).getMovie(m.getImdbID());
//	    		Link movieLink = linkTo(getmovie).withSelfRel();
//	    		m.add(movieLink);
    	}
    	//linkTo(MovieRestController.class).slash(m.getImdbID()).withSelfRel();
//            m.add(selfLink);
//            
//            if (si.getMovieById(m.getImdbID()).size() > 0) {
//                List<Order> methodLinkBuilder = 
//                  methodOn(CustomerController.class).getOrdersForCustomer(customer.getCustomerId());
//                Link ordersLink = linkTo(methodLinkBuilder).withRel("allOrders");
//                customer.add(ordersLink);
//            }
//    	}	
    	
    	return allMovies;
    		
   }
	
}
