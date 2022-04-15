package course_student.service;


import java.util.List;

import course_student.dao.Course_studentDao;
import course_student.domain.Course_student;

/**
 * logic functions such as register, login
 * @author Darian Danciu and Amanuel Odicho
 *
 */
public class Course_studentService {
	private Course_studentDao course_studentDao = new Course_studentDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Course_student form) throws Course_studentException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Course_student course_student = course_studentDao.findBySM_CN(form.getStudent_email(), form.getCourse_number());
		if(course_student.getStudent_email()!=null && course_student.getStudent_email().equals(form.getStudent_email()) && course_student.getCourse_number()!=null && course_student.getCourse_number().equals(form.getCourse_number()) ) throw new Course_studentException("This course_student already exists!");
		course_studentDao.add(form);
	}
	
	public List<Object> findOldCourse_students() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return course_studentDao.findOldCourse_students();
		
	}
}
