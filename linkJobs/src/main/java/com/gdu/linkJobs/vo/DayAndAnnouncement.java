package com.gdu.linkJobs.vo;

public class DayAndAnnouncement {
	private int day;
	private int price;
   
   
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
   
	@Override
	public String toString() {
		return "DayAndAnnouncement [day=" + day + ", price=" + price + "]";
	}
}
