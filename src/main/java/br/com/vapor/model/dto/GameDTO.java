package br.com.vapor.model.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.vapor.model.Game;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class GameDTO {
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private Double price;
	@NotNull
	private String aboutGame;
	@NotNull
	private Date dateAddedGame;	
	@NotNull
	private String genre;
	@NotNull
	private Boolean isItPurchased;
	@NotNull
	private String picture;
	
	public GameDTO(Game game) {
		this.id = game.getId();
		this.name = game.getName();
		this.price = game.getPrice();
		this.aboutGame = game.getAboutGame();
		this.dateAddedGame = game.getDateAddedGame();
		this.genre = game.getGenre();
		this.isItPurchased = game.getIsItPurchased();
		this.picture = game.getPicture();
		
	}
	
	public static List<GameDTO> converter (List<Game> games) {
		return games.stream().map(GameDTO::new).collect(Collectors.toList());
	}
}
