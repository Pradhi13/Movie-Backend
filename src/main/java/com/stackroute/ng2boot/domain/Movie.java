package com.stackroute.ng2boot.domain;

import java.util.ArrayList;
//import java.util.List;

import org.springframework.data.annotation.Id;

//import javax.persistence.*;

import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//@JsonSerialize
//@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection = "Moviedb")
public class Movie extends ResourceSupport {
	
	@Id
	String imdbid;
	//@JsonProperty("Title")
	String title;
	//@JsonProperty("Year")
	String release_date;
	//@JsonProperty("Poster")
	String poster_path;
	/**
	 * @return the id
	 */
	
	/**
	 * @return the title
	 */
	
	/**
	 * @return the imdbid
	 */
	public String getimdbid() {
		return imdbid;
	}
	/**
	 * @param imdbid the imdbid to set
	 */
	public void setimdbid(String imdbid) {
		this.imdbid = imdbid;
	}
	/**
	 * @param title the title to set
	 */
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the release_date
	 */
	public String getRelease_date() {
		return release_date;
	}
	/**
	 * @param release_date the release_date to set
	 */
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	/**
	 * @return the poster_path
	 */
	public String getPoster_path() {
		return poster_path;
	}
	/**
	 * @param poster_path the poster_path to set
	 */
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	
	
	
	
	
	
	
//	public void addLink(String url, String rel)
//	{
//		li.setLink(url);
//		li.setRel(rel);
//		linksList.add(li);
//	}
}
