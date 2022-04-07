package office_hour.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Office_Hour {
	/*
	 * Correspond to the user table
	 */
	
	private Integer id_office_hour;
	private Integer course_number;
	private String ta_email;
	private String location;
	private String meetup_time;
	private Date meetup_date;
	/**
	 * @return the id_office_hour
	 */
	public Integer getId_office_hour() {
		return id_office_hour;
	}
	/**
	 * @param id_office_hour the id_office_hour to set
	 */
	public void setId_office_hour(Integer id_office_hour) {
		this.id_office_hour = id_office_hour;
	}
	/**
	 * @return the course_number
	 */
	public Integer getCourse_number() {
		return course_number;
	}
	/**
	 * @param course_number the course_number to set
	 */
	public void setCourse_number(Integer course_number) {
		this.course_number = course_number;
	}
	/**
	 * @return the ta_email
	 */
	public String getTa_email() {
		return ta_email;
	}
	/**
	 * @param ta_email the ta_email to set
	 */
	public void setTa_email(String ta_email) {
		this.ta_email = ta_email;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the meetup_time
	 */
	public String getMeetup_time() {
		return meetup_time;
	}
	/**
	 * @param meetup_time the meetup_time to set
	 */
	public void setMeetup_time(String meetup_time) {
		this.meetup_time = meetup_time;
	}
	/**
	 * @return the meetup_date
	 */
	public Date getMeetup_date() {
		return meetup_date;
	}
	/**
	 * @param meetup_date the meetup_date to set
	 */
	public void setMeetup_date(Date meetup_date) {
		this.meetup_date = meetup_date;
	}
}
