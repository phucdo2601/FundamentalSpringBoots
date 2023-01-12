package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
		name = "tbl_student", 
		uniqueConstraints = @UniqueConstraint(
				name = "emailId_unique",
				columnNames = "email_address"
				)
		)
public class StudentEntity {
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
			)
	private Long studentId;
	private String firstName;
	private String lastName;
	@Column(
			name = "email_address",
			nullable = false
			)
	private String emailId;
//	private String guardianName;
//	private String guardianEmail;
//	private String guardianMobile;
	
	@Embedded
	private GuardianEntity guardian;
}
