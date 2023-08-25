package br.com.vapor.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.vapor.model.Profile;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ProfileDTO {
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String nickname;
	@NotNull
	private String aboutMe;
	@NotNull
	private String picture;
	@NotNull
	private String password;
	
	public ProfileDTO(Profile profile) {
		this.id = profile.getId();
		this.name = profile.getName();
		this.nickname = profile.getNickname();
		this.aboutMe = profile.getAboutMe();
		this.picture = profile.getPicture();
		this.password = profile.getPassword();
	}
	
	public static List<ProfileDTO> converter (List<Profile> profiles) {
		return profiles.stream().map(ProfileDTO::new).collect(Collectors.toList());
	}
}
