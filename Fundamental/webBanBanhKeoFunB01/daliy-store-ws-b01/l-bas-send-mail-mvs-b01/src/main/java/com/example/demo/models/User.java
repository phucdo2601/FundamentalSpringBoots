package com.example.demo.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "users_tbl")
public class User extends BaseEntity implements Serializable {
	private String name;
	private String email;
	private String password;
	private boolean isEnabled;
}
