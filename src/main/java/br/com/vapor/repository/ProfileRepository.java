package br.com.vapor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vapor.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	List<Profile> findByNameContaining (String name);
	
	Optional<Profile> findByEmail(String email);
    Optional<Profile> findByNicknameOrEmail(String nickname, String email);
    Optional<Profile> findByNickname(String nickname);
    Boolean existsByNickname(String nickname);
    Boolean existsByEmail(String email);
}
