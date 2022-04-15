package course.domain;

/**
 * Student object
 * 
 * @author Darian Danciu and Amanuel Odicho
 * 
 */
public class Course {
	
	private Integer course_number;
	private String teaching_assistant;
	private String professor;
	
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
	 * @return the teaching_assistant
	 */
	public String getTeaching_assistant() {
		return teaching_assistant;
	}
	/**
	 * @param teaching_assistant the teaching_assistant to set
	 */
	public void setTeaching_assistant(String teaching_assistant) {
		this.teaching_assistant = teaching_assistant;
	}
	/**
	 * @return the professor
	 */
	public String getProfessor() {
		return professor;
	}
	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	

}
