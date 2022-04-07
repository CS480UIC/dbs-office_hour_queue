package queue.domain;

import java.sql.Date;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Queue {
	/*
	 * Correspond to the user table
	 */
	
	private Integer id_queue;
	private String student_email;
	private String full_name;
	private String follow_up;
	private Date queue_date;
	private Integer officeHourID;
	/**
	 * @return the id_queue
	 */
	public Integer getId_queue() {
		return id_queue;
	}
	/**
	 * @param id_queue the id_queue to set
	 */
	public void setId_queue(Integer id_queue) {
		this.id_queue = id_queue;
	}
	/**
	 * @return the student_email
	 */
	public String getStudent_email() {
		return student_email;
	}
	/**
	 * @param student_email the student_email to set
	 */
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	/**
	 * @return the full_name
	 */
	public String getFull_name() {
		return full_name;
	}
	/**
	 * @param full_name the full_name to set
	 */
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	/**
	 * @return the follow_up
	 */
	public String getFollow_up() {
		return follow_up;
	}
	/**
	 * @param follow_up the follow_up to set
	 */
	public void setFollow_up(String follow_up) {
		this.follow_up = follow_up;
	}
	/**
	 * @return the queue_date
	 */
	public Date getQueue_date() {
		return queue_date;
	}
	/**
	 * @param queue_date the queue_date to set
	 */
	public void setQueue_date(Date queue_date) {
		this.queue_date = queue_date;
	}
	/**
	 * @return the officeHourID
	 */
	public Integer getOfficeHourID() {
		return officeHourID;
	}
	/**
	 * @param officeHourID the officeHourID to set
	 */
	public void setOfficeHourID(Integer officeHourID) {
		this.officeHourID = officeHourID;
	}
	
	
}
