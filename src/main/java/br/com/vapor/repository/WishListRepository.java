package br.com.vapor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vapor.model.WishList;

public interface WishListRepository  extends JpaRepository<WishList, Long> {

	List<WishList> findNameByContaining (String name);
	
}
