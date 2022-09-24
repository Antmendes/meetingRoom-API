package com.crud.saladereuniao.saladereuniao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="meetingRoom")
public class Room {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "date", nullable = false)
	private String date;
	
	@Column(name = "startMeeting", nullable = false)
	private String startMeeting;
	
	@Column(name = "endMeeting", nullable = false)
	private String endMeeting;
	
	
	public Room() {}
	
	public Room(long id, String name, String date, String startMeeting, String endMeeting) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.startMeeting = startMeeting;
		this.endMeeting = endMeeting;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartMeeting() {
		return startMeeting;
	}
	public void setStartMeeting(String startMeeting) {
		this.startMeeting = startMeeting;
	}
	public String getEndMeeting() {
		return endMeeting;
	}
	public void setEndMeeting(String endMeeting) {
		this.endMeeting = endMeeting;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", date=" + date + ", startMeeting=" + startMeeting
				+ ", endMeeting=" + endMeeting + "]";
	}
	
	

}
