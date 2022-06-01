package com.sbnz.trud.io.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
@Entity
@Table(name = "glucose_levels")
@SQLDelete(sql = "UPDATE glucose_levels SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class DailyGlucoseLevel extends BaseEntity {
	private LocalDate date;
	private float preprandial;
	private float firstPostprandial;
	private float secondPostprandial;
	
	public DailyGlucoseLevel() {
		super();
	}

	
	public DailyGlucoseLevel(LocalDate date, float preprandial, float firstPostprandial, float secondPostprandial) {
		super();
		this.date = date;
		this.preprandial = preprandial;
		this.firstPostprandial = firstPostprandial;
		this.secondPostprandial = secondPostprandial;
	}


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public float getPreprandial() {
		return preprandial;
	}

	public void setPreprandial(float preprandial) {
		this.preprandial = preprandial;
	}

	public float getFirstPostprandial() {
		return firstPostprandial;
	}

	public void setFirstPostprandial(float firstPostprandial) {
		this.firstPostprandial = firstPostprandial;
	}

	public float getSecondPostprandial() {
		return secondPostprandial;
	}

	public void setSecondPostprandial(float secondPostprandial) {
		this.secondPostprandial = secondPostprandial;
	}
}
