package com.junho.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.junho.dto.Summoner;
import com.junho.util.SummonerParser;

@RestController
@CrossOrigin(origins= {"*"}, maxAge=6000)
public class Controller {

	@GetMapping(value = "/summoner/{name}")
	public ResponseEntity<Summoner> summoner(@PathVariable String name) {
		SummonerParser summonerParser = new SummonerParser();
		Summoner summoner = summonerParser.getJsonData(name);

		if(summoner != null && !summoner.equals(null)) {
			return new ResponseEntity<Summoner>(summoner,HttpStatus.OK);
		}
		return new ResponseEntity<Summoner>(HttpStatus.NO_CONTENT);
	}
}
