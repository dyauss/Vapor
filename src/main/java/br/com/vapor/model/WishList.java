package br.com.vapor.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_WISHLIST")
@SequenceGenerator(name = "wishListSequence", sequenceName = "SQ_WISHLIST", allocationSize = 1)
public class WishList {
	
	private List<Game> games = new ArrayList<Game>();
	
	@Id
	@Column(name = "id_wishlist")
	@GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "wishListSequence")
	private Long id;

	public WishList(List<Game> games, Long id) {
		super();
		this.games = games;
		this.id = id;
	}

	public List<Game> getGames() {
		return games;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
}
