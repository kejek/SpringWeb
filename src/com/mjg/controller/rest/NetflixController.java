package com.mjg.controller.rest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjg.aspect.Loggable;
import com.mjg.model.Movie;

@RestController
@RequestMapping(value = "/netflix", produces = "application/json")
public class NetflixController {

	private final static String BASE_URI = "http://netflixroulette.net/api/api.php";

	@Loggable
	@RequestMapping(value = "name", method = RequestMethod.GET)
	public ResponseEntity<Object> testMovieNoName() {
		Movie movie = new Movie();
		RestTemplate rt = new RestTemplate();
		String URI = BASE_URI + "?title={name}";
		// JSON from file to Object
		movie = rt.getForObject(URI, Movie.class, "Black Hawk Down");

		return new ResponseEntity<Object>(movie, HttpStatus.OK);
	}

	@Loggable
	@RequestMapping(value = "name/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> testMovie(@PathVariable String name) {
		Movie movie = new Movie();
		RestTemplate rt = new RestTemplate();
		String URI = BASE_URI + "?title={name}";
		// JSON from file to Object
		movie = rt.getForObject(URI, Movie.class, name);

		return new ResponseEntity<Object>(movie, HttpStatus.OK);
	}

	@Loggable
	@RequestMapping(value = "error/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> testError(@PathVariable String name) throws JsonMappingException {
		// Forces an Error
		throw new JsonMappingException(name);
	}

	@Loggable
	@RequestMapping(value = "error2/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> testError2(@PathVariable String name) throws Exception {
		// Forces an Error
		throw new Exception(name);
	}
}
