package br.com.vapor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vapor.model.Profile;
import br.com.vapor.model.dto.ProfileDTO;
import br.com.vapor.service.ProfileService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/profiles")
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProfileDTO> getAll() {
		return profileService.getAll();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProfileDTO> post(@RequestBody Profile profile, UriComponentsBuilder uriBuilder) {
		return profileService.post(profile, uriBuilder);
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<ProfileDTO> put(@PathVariable("id") Long id, @RequestBody @Valid Profile profileNew) {
		return profileService.put(id, profileNew);
	}
	
	@PatchMapping("{id}")
	@Transactional
	public ResponseEntity<ProfileDTO> patch(@PathVariable("id") Long id, @RequestBody @Valid Profile profileNew) {
		return profileService.patch(id, profileNew);
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return profileService.delete(id);
	}
}
