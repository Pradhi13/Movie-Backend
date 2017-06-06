package com.stackroute.ng2boot.controllers.assembler;

import java.util.List;

import com.stackroute.ng2boot.domain.Movie;

public interface HateoasLinkAssembler {
	public Iterable<Movie> AssembleMovie(List<Movie> allMovies);
}
