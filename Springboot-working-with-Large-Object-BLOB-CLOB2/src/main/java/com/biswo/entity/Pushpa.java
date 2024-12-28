package com.biswo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="PUSHPA_INFO")
@Data
public class Pushpa {
	@Id
	@SequenceGenerator(name="filmgen",initialValue=100,allocationSize=5,sequenceName="FILM_ID_SEQ")
	@GeneratedValue(generator="filmgen",strategy=GenerationType.SEQUENCE)
	private Integer filmId;
	@Column(length=30)
	private String heroName;
	@Column(length=30)
	private String heroineName;
	private LocalDateTime releaseDate;
	@Lob
	private byte[] filmTrailer;
	@Lob
	private char[] filmDocument;
}
