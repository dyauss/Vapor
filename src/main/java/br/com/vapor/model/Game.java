package br.com.vapor.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TB_GAME")
@SequenceGenerator(name = "profileSequence", sequenceName = "SQ_PROFILE", allocationSize = 1)
public class Game {
	
	@Id
	@Column(name = "id_game")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gameSequence")
	private Long id;
	
	@Column(name = "name_game")
	private String name;
	
	@Column(name = "price_game")
	private Double price;
	
	@Column(name = "aboutGame_game")
	private String aboutGame;
	
	@Column(name = "dateAddedGame_game")
	private Date dateAddedGame;
	
	@Column(name = "genre_game")
	private String genre;
	
	@Column(name = "purchase_game")
	private Boolean isItPurchased;
	
	@Column(name = "pic_game")
	private String picture;

	public Game(Long id, String name, Double price, String aboutGame, Date dateAddedGame, String genre, Boolean isItPurchased, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.aboutGame = aboutGame;
		this.dateAddedGame = dateAddedGame;
		this.genre = genre;
		this.isItPurchased = isItPurchased;
		this.picture = picture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getAboutGame() {
		return aboutGame;
	}

	public void setAboutGame(String aboutGame) {
		this.aboutGame = aboutGame;
	}
	
	public Date getDateAddedGame() {
		return dateAddedGame;
	}

	public void setDateAddedGame(Date dateAddedGame) {
		this.dateAddedGame = dateAddedGame;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Boolean getIsItPurchased() {
		return isItPurchased;
	}

	public void setIsItPurchased(Boolean isItPurchased) {
		this.isItPurchased = isItPurchased;
	}
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
