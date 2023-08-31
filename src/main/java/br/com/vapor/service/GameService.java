package br.com.vapor.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vapor.model.Game;
import br.com.vapor.model.dto.GameDTO;
import br.com.vapor.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	GameRepository gameRepository;
	
	public ResponseEntity<GameDTO> get(Long id) {
		Optional<Game> game = gameRepository.findById(id);
		
		return game.map(p -> ResponseEntity.ok(new GameDTO(p))).orElse(ResponseEntity.notFound().build());
	}

	public List<GameDTO> getAll() {
		List<Game> games = gameRepository.findAll();
		
		return GameDTO.converter(games);
	}
	
	public ResponseEntity<GameDTO> post(Game game, UriComponentsBuilder uriBuilder) {
		gameRepository.save(game);
		
		URI uri = uriBuilder.path("/games/{id}").buildAndExpand(game.getId()).toUri();
		return ResponseEntity.created(uri).body(new GameDTO(game));
	}
	
	public ResponseEntity<GameDTO> put(Long id, Game gameNew) {
		Optional<Game> game = gameRepository.findById(id);
		
		return game.map(p -> {
			p.setAboutGame(gameNew.getAboutGame());
			p.setDateAddedGame(gameNew.getDateAddedGame());
			p.setGenre(gameNew.getGenre());
			p.setIsItPurchased(gameNew.getIsItPurchased());
			p.setName(gameNew.getName());
			p.setPicture(gameNew.getPicture());
			p.setPrice(gameNew.getPrice());
			
			gameRepository.save(p);
			return ResponseEntity.ok(new GameDTO(p));
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<GameDTO> patch(Long id, Game gameNew) {
		Optional<Game> game = gameRepository.findById(id);
		
		gameNew.equals(game != null ? "true" : "false");
		
		return game.map(p -> {
			p.setAboutGame(gameNew.getAboutGame() == null ? p.getAboutGame() : gameNew.getAboutGame());
			p.setDateAddedGame(gameNew.getDateAddedGame() == null ? p.getDateAddedGame() : gameNew.getDateAddedGame());
			p.setGenre(gameNew.getGenre() == null ? p.getGenre() : gameNew.getGenre());
			p.setIsItPurchased(gameNew.getIsItPurchased() == null ? p.getIsItPurchased() : gameNew.getIsItPurchased());
			p.setName(gameNew.getName() == null ? p.getName() : gameNew.getName());
			p.setPicture(gameNew.getPicture() == null ? p.getPicture() : gameNew.getPicture());
			p.setPrice(gameNew.getPrice() == null ? p.getPrice() : gameNew.getPrice());
			
			gameRepository.save(p);
			return ResponseEntity.ok(new GameDTO(p));
			
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<?> delete(Long id) {
		Optional<Game> game = gameRepository.findById(id);
		
		return game.map(p -> {
			gameRepository.deleteById(id);
			return ResponseEntity.ok("Game id: " + id + " erased");
		}).orElse(ResponseEntity.notFound().build());
	}
}