package com.phucdn.sendverifylink.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "confirmationToken")
public class ConfirmationTokenEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tokenId;

	@Column(name = "confirmation_token", length = 255, columnDefinition = "nvarchar(255) null")
	private String confirmationToken;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@OneToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private UserEntity userEntity;

	public ConfirmationTokenEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
		createdDate = new Date();
		confirmationToken = UUID.randomUUID().toString();
	}
}
