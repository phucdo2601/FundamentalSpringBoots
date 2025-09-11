package com.web.phucdn.models;

import java.io.Serializable;

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
@Entity(name = "staffs_tbl")
public class Staff extends BaseEntity implements Serializable {
	private String staffCode;

	/**
	 * Make relationShip One to One (O-n-O) beetween GeneralUserInfo and Staff
	 * (Staff is the main table)
	 */
	@OneToOne
	@JoinColumn(name = "genUserInfoId")
	private GeneralUserInfo generalUserInfo;

	@ManyToOne
	@JoinColumn(name = "staffRoleId")
	private StaffRole staffRole;
}
