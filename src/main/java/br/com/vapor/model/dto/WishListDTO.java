package br.com.vapor.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.vapor.model.Game;
import br.com.vapor.model.WishList;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class WishListDTO {

	private Long id;
	@NotNull
	private List<Game> games;
	
	public WishListDTO(WishList wishList) {
		this.id = wishList.getId();
		this.games = wishList.getGames();
	}
	
	public static List<WishListDTO> converter (List<WishList> wishLists) {
		return wishLists.stream().map(WishListDTO::new).collect(Collectors.toList());
	}
	
}
