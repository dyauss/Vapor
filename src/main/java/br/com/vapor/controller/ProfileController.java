package br.com.vapor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vapor.repository.ProfileRepository;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/profiles")
public class ProfileController {

	@Autowired
	ProfileRepository repository;
}
