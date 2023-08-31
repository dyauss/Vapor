package br.com.vapor.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vapor.model.Profile;
import br.com.vapor.model.dto.ProfileDTO;
import br.com.vapor.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	ProfileRepository profileRepository;
	
	public ResponseEntity<ProfileDTO> get(Long id) {
		Optional<Profile> profile = profileRepository.findById(id);
		
		return profile.map(p -> ResponseEntity.ok(new ProfileDTO(p))).orElse(ResponseEntity.notFound().build());
	}

	public List<ProfileDTO> getAll() {
		List<Profile> profiles = profileRepository.findAll();
		
		return ProfileDTO.converter(profiles);
	}
	
	public ResponseEntity<ProfileDTO> post(Profile profile, UriComponentsBuilder uriBuilder) {
		profileRepository.save(profile);
		
		URI uri = uriBuilder.path("/profiles/{id}").buildAndExpand(profile.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProfileDTO(profile));
	}
	
	public ResponseEntity<ProfileDTO> put(Long id, Profile profileNew) {
		Optional<Profile> profile = profileRepository.findById(id);
		
		return profile.map(p -> {
			p.setAboutMe(profileNew.getAboutMe());
			p.setName(profileNew.getName());
			p.setNickname(profileNew.getNickname());
			p.setPassword(profileNew.getPassword());
			p.setPicture(profileNew.getPicture());
			
			profileRepository.save(p);
			return ResponseEntity.ok(new ProfileDTO(p));
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<ProfileDTO> patch(Long id, Profile profileNew) {
		Optional<Profile> profile = profileRepository.findById(id);
		
		profileNew.equals(profile != null ? "true" : "false");
		
		return profile.map(p -> {
			p.setAboutMe(profileNew.getAboutMe() == null ? p.getAboutMe() : profileNew.getAboutMe());
			p.setName(profileNew.getName() == null ? p.getName() : profileNew.getName());
			p.setNickname(profileNew.getNickname() == null ? p.getNickname() : profileNew.getNickname());
			p.setPassword(profileNew.getPassword() == null ? p.getPassword() : profileNew.getPassword());
			p.setPicture(profileNew.getPicture() == null ? p.getPicture() : profileNew.getPicture());
			
			profileRepository.save(p);
			return ResponseEntity.ok(new ProfileDTO(p));
			
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<?> delete(Long id) {
		Optional<Profile> profile = profileRepository.findById(id);
		
		return profile.map(p -> {
			profileRepository.deleteById(id);
			return ResponseEntity.ok("Profile id: " + id + " erased");
		}).orElse(ResponseEntity.notFound().build());
	}
}
