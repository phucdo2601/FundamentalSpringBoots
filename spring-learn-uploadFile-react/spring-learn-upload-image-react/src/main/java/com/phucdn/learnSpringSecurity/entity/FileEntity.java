package com.phucdn.learnSpringSecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "files")
public class FileEntity {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "name", columnDefinition = "nvarchar(255) null")
	private String name;
	@Column(name = "type", columnDefinition = "nvarchar(255) null")
	private String type;
	@Lob
	@Column(name = "data", nullable = false, length = Integer.MAX_VALUE)
	private byte[] data;
	
	public FileEntity(String name, String type, byte[] data) {
	    this.name = name;
	    this.type = type;
	    this.data = data;
	  }
}
