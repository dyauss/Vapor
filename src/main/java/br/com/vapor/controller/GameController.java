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

import br.com.vapor.model.Game;
import br.com.vapor.model.dto.GameDTO;
import br.com.vapor.repository.GameRepository;
import br.com.vapor.service.GameService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/games")
public class GameController {
	@Autowired
	private GameService gameService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<GameDTO> getAll() {
		return gameService.getAll();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<GameDTO> post(@RequestBody Game game, UriComponentsBuilder uriBuilder) {
		return gameService.post(game, uriBuilder);
	}
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<GameDTO> put(@PathVariable("id") Long id, @RequestBody @Valid Game gameNew) {
		return gameService.put(id, gameNew);
	}
	
	@PatchMapping("{id}")
	@Transactional
	public ResponseEntity<GameDTO> patch(@PathVariable("id") Long id, @RequestBody @Valid Game gameNew) {
		return gameService.patch(id, gameNew);
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return gameService.delete(id);
	}
}
