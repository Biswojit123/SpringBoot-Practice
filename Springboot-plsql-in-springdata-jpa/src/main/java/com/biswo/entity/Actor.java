package com.biswo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="Actor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Actor {
	@Id
	@Column(name="ACTORID")
	@GeneratedValue
	private Integer actorId;
	@NonNull
	@Column(name="ACTORNAME",length=30)
	private String actorName;
	@NonNull
	@Column(name="ACTORCATEGORY",length=30)
	private String actorCategory;
	@NonNull
	@Column(name="ACTORMOB")
	private Long actorMOB;
}
