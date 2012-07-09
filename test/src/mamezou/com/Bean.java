package mamezou.com;

import java.io.Serializable;

import android.app.Activity;

public class Bean implements Serializable{

	private static final long serialVersionUID = 1L;

	private String date;
	private String holl_name;
	private String type_name;
	private String invest;
	private String collect;
	private String note;
	private int year;
	private int month;
	private int day;

	public Bean(){
	}

	public void setBean(String holl_name, String type_name, String invest, String collect, String note){
		this.holl_name = holl_name;
		this.type_name = type_name;
		this.invest = invest;
		this.collect = collect;
		this.note = note;
	}

	public void date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getyear(){
		return year;
	}

	public int getmonth(){
		return month;
	}

	public int getday(){
		return day;
	}

	public String getDate() {
		date = this.year + "/" + this.month + "/" + this.day;
		return date;
	}

	public String getHoll_name() {
		return holl_name;
	}

	public String getType_name() {
		return type_name;
	}

	public String getInvest() {
		return invest;
	}

	public String getCollect() {
		return collect;
	}

	public String getnote() {
		return note;
	}

}
