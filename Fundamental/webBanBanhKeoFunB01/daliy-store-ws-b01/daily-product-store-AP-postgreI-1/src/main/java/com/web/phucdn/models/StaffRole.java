package com.web.phucdn.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "staffRoles_tbl")
public class StaffRole extends BaseEntity implements Serializable {
	private String staffRoleCode;
	private String staffRoleTitle;

	@OneToMany(mappedBy = "staffRole", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Staff> listStaffs;
}
