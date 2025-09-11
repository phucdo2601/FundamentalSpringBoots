package com.web.phucdn.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "generalUserInfo_tbl")
public class GeneralUserInfo extends BaseEntity implements Serializable, UserDetails {
	private String fullName;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private String nationalId;
	private Timestamp dateOfBirth;
	private String gender;
	private String address;
	private Timestamp dateOfCreate;
	private Timestamp dateOfLastUpdate;
	private boolean isActive;

	/**
	 * How to make relation ahip one to one (O-n-O) in Java Spring JPA In this
	 * example: I will choose table GeneralUserInfo and Customer: - Customer is the
	 * main table -> Therefore, the Customer has foreignKey of GeneralUserInfo table
	 * 
	 * => Class GeneralUserInfo has mappedBy the manual definition on the other
	 * class has the foreign key of this table
	 */
	@OneToOne(mappedBy = "generalUserInfo")
	@JsonBackReference
	private Customer customer;

	@OneToOne(mappedBy = "generalUserInfo")
	@JsonBackReference
	private Staff staff;

	@ManyToOne
	@JoinColumn(name = "genRoleId")

	/**
	 * @JsonManagedReference and @JsonBackReference to manage the serialization
	 *                       manually: it will skip serialization of the field
	 *                       annotated with @JsonBackReference
	 */
	@JsonBackReference
	private GeneralRole generalRole;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return List.of(new SimpleGrantedAuthority(generalRole.getGenRoleCode()));
	}

	@Override
	public String getUsername() {

		return this.userName;
	}

	@Override
	public String getPassword() {
		return this.password;

	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
