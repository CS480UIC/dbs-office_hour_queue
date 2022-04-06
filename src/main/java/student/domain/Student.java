package student.domain;

/**
 * Student object
 * 
 * @author Darian Danciu and Amanuel Odicho
 * 
 */
public class Student {
	/*
	 * Correspond to the user table
	 */
	
	private String student_email;
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
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the queueID
	 */
	public Integer getQueueID() {
		return queueID;
	}
	/**
	 * @param queueID the queueID to set
	 */
	public void setQueueID(Integer queueID) {
		this.queueID = queueID;
	}
	/**
	 * @return the is_ta
	 */
	public String getIs_ta() {
		return is_ta;
	}
	/**
	 * @param is_ta the is_ta to set
	 */
	public void setIs_ta(String is_ta) {
		this.is_ta = is_ta;
	}
	private String full_name;
	private String note;
	private Integer queueID;
	private String is_ta;
}
