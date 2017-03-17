package com.mjg.controller.rest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjg.model.Movie;
import com.mjg.model.Search;

@RestController
@RequestMapping(value = "/netflix", produces = "application/json")
public class NetflixController {

	@RequestMapping(value = "name", method = RequestMethod.POST)
	public Movie getMoviesByName(@ModelAttribute("search") Search search) {
		return new Movie();
	}

	@RequestMapping(value = "name", method = RequestMethod.GET)
	public ResponseEntity<Object> testMovie() {
		Movie movie = new Movie();
		ObjectMapper mapper = new ObjectMapper();
		// JSON from file to Object
		try {
			movie = mapper.readValue(new URL("http://netflixroulette.net/api/api.php?title=Breaking%20Bad"),
					Movie.class);
		} catch (JsonParseException e) {
			return new ResponseEntity<Object>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (JsonMappingException e) {
			return new ResponseEntity<Object>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (MalformedURLException e) {
			return new ResponseEntity<Object>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (IOException e) {
			return new ResponseEntity<Object>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Object>(movie, HttpStatus.OK);
	}
}
