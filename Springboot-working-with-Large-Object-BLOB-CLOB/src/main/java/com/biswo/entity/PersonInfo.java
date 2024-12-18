package com.biswo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Person_Info")
@Data
public class PersonInfo {
	@Id
	@GeneratedValue
	private Integer personId;
	@Column(length=30)
	private String personName;
	private LocalDateTime dob;
	private boolean isMarried;
	@Lob
	private byte[] photo;
	@Lob
	private char[] resume;
}
