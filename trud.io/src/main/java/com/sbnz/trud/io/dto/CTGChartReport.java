package com.sbnz.trud.io.dto;

import com.sbnz.trud.io.model.CTGStatus;

public class CTGChartReport {
	private int y;
	private String x;
	
	public CTGChartReport() {
		super();
	}
	public CTGChartReport(int value, CTGStatus status) {
		super();
		this.y = value;
		this.x = this.convert(status);
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	
	public String convert(CTGStatus status) {
		if(status == CTGStatus.ABNORMAL)
		{
			return "Abnormalno";
		}
		else if (status == CTGStatus.NON_REASSURING) 
		{
			return "Sumnjivo";
		}
		
		return "Normalno";
	}
}
