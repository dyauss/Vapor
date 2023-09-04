package br.com.vapor.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vapor.model.WishList;
import br.com.vapor.model.dto.WishListDTO;
import br.com.vapor.repository.WishListRepository;

@Service
public class WishListService {

	@Autowired
	WishListRepository wishListRepository;
	
	public ResponseEntity<WishListDTO> get(Long id) {
		Optional<WishList> wishList = wishListRepository.findById(id);
		
		return wishList.map(p -> ResponseEntity.ok(new WishListDTO(p))).orElse(ResponseEntity.notFound().build());
	}
	
	public List<WishListDTO> getAll() {
		List<WishList> wishLists = wishListRepository.findAll();
		
		return WishListDTO.converter(wishLists);
	}
	
	public ResponseEntity<WishListDTO> post(WishList wishList, UriComponentsBuilder uriBuilder){
		wishListRepository.save(wishList);
		
		URI uri = uriBuilder.path("/wishLists/{id}").buildAndExpand(wishList.getId()).toUri();
		return ResponseEntity.created(uri).body(new WishListDTO(wishList));
	}
	
	public ResponseEntity<WishListDTO> put (Long id, WishList wishListNew){
		Optional<WishList> wishList = wishListRepository.findById(id);
		
		return wishList.map(p ->{
			p.setGames(wishListNew.getGames());
			
			wishListRepository.save(p);
			return ResponseEntity.ok(new WishListDTO(p));
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<WishListDTO> patch(Long id, WishList wishListNew){
		Optional<WishList> wishList = wishListRepository.findById(id);
		
		wishListNew.equals(wishList != null ? "true" : "false");
		
		return wishList.map(p -> {
			p.setGames(wishListNew.getGames() == null ? p.getGames() : wishListNew.getGames());
			
			wishListRepository.save(p);
			return ResponseEntity.ok(new WishListDTO(p));
		}).orElse(ResponseEntity.notFound().build());
	}
	public ResponseEntity<?> delete (Long id) {
		Optional<WishList> wishList = wishListRepository.findById(id);
		
		return wishList.map(p -> {
			wishListRepository.deleteById(id);
			return ResponseEntity.ok("WishList id: " + id + " erased");
		}).orElse(ResponseEntity.notFound().build());
	}
	
}
