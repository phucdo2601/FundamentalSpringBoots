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
@Entity(name = "generalRoles_tbl")
public class GeneralRole extends BaseEntity implements Serializable {
	private String genRoleCode;
	private String genRoleTitle;

	@OneToMany(mappedBy = "generalRole", cascade = CascadeType.ALL)
	/**
	 * @JsonManagedReference and @JsonBackReference to manage the serialization
	 *                       manually Jackson will only serialize the field
	 *                       annotated with @JsonManagedReference
	 */

	@JsonManagedReference
	private List<GeneralUserInfo> listGeneralUserInfos;
}
