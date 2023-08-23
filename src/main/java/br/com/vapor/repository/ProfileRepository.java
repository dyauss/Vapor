package br.com.vapor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vapor.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	List<Profile> findByNameContaining (String name);
}
