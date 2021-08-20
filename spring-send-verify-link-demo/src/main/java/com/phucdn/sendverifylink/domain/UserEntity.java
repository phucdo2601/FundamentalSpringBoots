package com.phucdn.sendverifylink.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long userId;
	
	private String emailId;
	
	private String password;
	
	@Column(name = "first_name", length = 255, 
			columnDefinition = "nvarchar(255) null")
	private String firstName;
	
	@Column(name = "last_name", length = 255, 
			columnDefinition = "nvarchar(255) null")
	private String lastName;
	
	private boolean isEnabled;
}
