package ta_list.domain;

/**
 * Student object
 * 
 * @author Darian Danciu and Amanuel Odicho
 * 
 */
public class Ta_list {
	
	private String ta_email;
	private Integer ta_course_number;
	private String ta_course_department;
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
	 * @return the ta_course_number
	 */
	public Integer getTa_course_number() {
		return ta_course_number;
	}
	/**
	 * @param ta_course_number the ta_course_number to set
	 */
	public void setTa_course_number(Integer ta_course_number) {
		this.ta_course_number = ta_course_number;
	}
	/**
	 * @return the ta_course_department
	 */
	public String getTa_course_department() {
		return ta_course_department;
	}
	/**
	 * @param ta_course_department the ta_course_department to set
	 */
	public void setTa_course_department(String ta_course_department) {
		this.ta_course_department = ta_course_department;
	}

}
