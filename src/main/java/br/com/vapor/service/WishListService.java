package br.com.vapor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.vapor.model.WishList;
import br.com.vapor.model.dto.WishListDTO;
import br.com.vapor.repository.WishListRepository;

@Service
public class WishListService {

	@Autowired
	WishListRepository wishListRepository;
	
	public ResponseEntity<WishListDTO> get(Long id) {
		Optional<WishList> wishLists = wishListRepository.findAll();
	}
	
	public List<WishListDTO> getAll() {
		List<WishList> wishLists = wishListRepository.findAll();
		
		return WishListDTO.converter(wishLists);
	}
}
