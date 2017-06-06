package com.stackroute.ng2boot.repository;

//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.ng2boot.domain.Movie;

@Repository
public interface MovieRepository extends  MongoRepository<Movie, String> {
//public interface MovieRepository extends CrudRepository<Movie, String>{
	

	

	

}
