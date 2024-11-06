package com.biswo.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="DATA_JPA_ACTOR")
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class Actors {
	@Id
	@Column(name="ACTOR_ID")
	@GeneratedValue
	private Integer actorId;
	@NonNull
	@Column(name="ACTOR_NAME")
	private String actorName;
	@NonNull
	@Column(name="ACTOR_CATEGORY")
	private String actorCategory;
	@NonNull
	@Column(name="ACTOR_MOB_NUM")
	private Long mobileNum;
	@Version
	@Column(name="UPDATION_COUNT")
	private Integer updationCount;//for version 
	@CreationTimestamp
	@Column(name="LUNCH_TIME")
	private Timestamp lunchTime;//for time time stamping
	@UpdateTimestamp
	@Column(name="LAST_UPDATION")
	private Timestamp lastUpdationTime;//for time stamping
	public Actors() {
		System.out.println("0-param constructor of actors object"+this.getClass());
	}
	
}
