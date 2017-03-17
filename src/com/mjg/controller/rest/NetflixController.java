package com.mjg.controller.rest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjg.aspect.Loggable;
import com.mjg.model.Movie;
import com.mjg.model.Search;

@RestController
@RequestMapping(value = "/netflix", produces = "application/json")
public class NetflixController {

	@Loggable
	@RequestMapping(value = "name", method = RequestMethod.GET)
	public ResponseEntity<Object> testMovieNoName() {
		Movie movie = new Movie();
		ObjectMapper mapper = new ObjectMapper();
		// JSON from file to Object
		try {
			movie = mapper.readValue(new URL("http://netflixroulette.net/api/api.php?title=Black%20Hawk%20Down"),
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

	@Loggable
	@RequestMapping(value = "name/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> testMovie(@PathVariable String name) {
		Movie movie = new Movie();
		ObjectMapper mapper = new ObjectMapper();
		// JSON from file to Object
		try {
			movie = mapper.readValue(new URL("http://netflixroulette.net/api/api.php?title=" + name), Movie.class);
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

	@Loggable
	@RequestMapping(value = "error/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> testError(@PathVariable String name) throws JsonMappingException {
		// Forces an Error
		throw new JsonMappingException(name);
	}
}
