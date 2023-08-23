package br.com.vapor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vapor.repository.GameRepository;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/games")
public class GameController {

	@Autowired
	GameRepository repository;
}
