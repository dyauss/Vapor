package br.com.vapor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PROFILE", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nick_profile"}),
        @UniqueConstraint(columnNames = {"email_profile"})
})
@SequenceGenerator(name = "profileSequence", sequenceName = "SQ_PROFILE", allocationSize = 1)
@Data
@NoArgsConstructor
public class Profile {
	
	@Id
	@Column(name = "id_profile")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profileSequence")
	private Long id;
	
	@Column(name = "name_profile")
	private String name;
	
	@Column(name = "email_profile")
	private String email;
	
	@Column(name = "nick_profile")
	private String nickname;
	
	@Column(name = "about_profile")
	private String aboutMe;
	
	@Column(name = "pic_profile")
	private String picture;
	
	@Column(name = "password_profile")
	private String password;
}
