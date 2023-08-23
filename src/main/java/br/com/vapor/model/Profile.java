package br.com.vapor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PROFILE")
@SequenceGenerator(name = "profileSequence", sequenceName = "SQ_PROFILE", allocationSize = 1)
public class Profile {
	
	@Id
	@Column(name = "id_profile")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profileSequence")
	private Long id;
	
	@Column(name = "name_profile")
	private String name;
	
	@Column(name = "nick_profile")
	private String nickname;
	
	@Column(name = "about_profile")
	private String aboutMe;
	
	@Column(name = "pic_profile")
	private String picture;

	public Profile(Long id, String name, String nickname, String aboutMe, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.aboutMe = aboutMe;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
