package com.sbnz.trud.io.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "weekly_parameters")
@SQLDelete(sql = "UPDATE triple_test SET deleted = true WHERE id=? AND version = ?")
@Where(clause = "deleted=false")
public class WeeklyParameters extends BaseEntity{
	
	private int week;
	
	private double medianAfp;
	
	private double medianHcg;
	
	private double medianPappa;
	
	private double medianInhibinA;
	
	private double medianUe3;
	
	public WeeklyParameters() {}

	public WeeklyParameters(int week, double medianAfp, double medianHcg, double medianPappa, double medianInhibinA,
			double medianUe3) {
		super();
		this.week = week;
		this.medianAfp = medianAfp;
		this.medianHcg = medianHcg;
		this.medianPappa = medianPappa;
		this.medianInhibinA = medianInhibinA;
		this.medianUe3 = medianUe3;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public double getMedianAfp() {
		return medianAfp;
	}

	public void setMedianAfp(double medianAfp) {
		this.medianAfp = medianAfp;
	}

	public double getMedianHcg() {
		return medianHcg;
	}

	public void setMedianHcg(double medianHcg) {
		this.medianHcg = medianHcg;
	}

	public double getMedianPappa() {
		return medianPappa;
	}

	public void setMedianPappa(double medianPappa) {
		this.medianPappa = medianPappa;
	}

	public double getMedianInhibinA() {
		return medianInhibinA;
	}

	public void setMedianInhibinA(double medianInhibinA) {
		this.medianInhibinA = medianInhibinA;
	}

	public double getMedianUe3() {
		return medianUe3;
	}

	public void setMedianUe3(double medianUe3) {
		this.medianUe3 = medianUe3;
	}
	
	

}
