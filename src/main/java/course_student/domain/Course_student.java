package course_student.domain;

/**
 * Student object
 * 
 * @author Darian Danciu and Amanuel Odicho
 * 
 */
public class Course_student {
	
	private String student_email;
	private Integer course_number;

	private String student_email_UPDATE;
	private Integer course_number_UPDATE;
	
	/**
	 * @return the student_email_UPDATE
	 */
	public String getStudent_email_UPDATE() {
		return student_email_UPDATE;
	}
	/**
	 * @param student_email_UPDATE the student_email_UPDATE to set
	 */
	public void setStudent_email_UPDATE(String student_email_UPDATE) {
		this.student_email_UPDATE = student_email_UPDATE;
	}
	/**
	 * @return the course_number_UPDATE
	 */
	public Integer getCourse_number_UPDATE() {
		return course_number_UPDATE;
	}
	/**
	 * @param course_number_UPDATE the course_number_UPDATE to set
	 */
	public void setCourse_number_UPDATE(Integer course_number_UPDATE) {
		this.course_number_UPDATE = course_number_UPDATE;
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


}
