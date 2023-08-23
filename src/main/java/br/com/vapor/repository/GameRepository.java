package br.com.vapor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vapor.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

	List<Game> findByNameContaining (String name);
}
