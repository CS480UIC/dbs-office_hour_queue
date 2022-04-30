package course.service;


import java.util.List;

import course.dao.CourseDao;
import course.domain.Course;

/**
 * logic functions such as register, login
 * @author Darian Danciu and Amanuel Odicho
 *
 */
public class CourseService {
	private CourseDao courseDao = new CourseDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Course form) throws CourseException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Course ta_list = courseDao.findByCourse_number(form.getCourse_number());
		if(ta_list.getCourse_number()!=null && ta_list.getCourse_number().equals(form.getCourse_number())) throw new CourseException("This course already exists!");
		courseDao.add(form);
	}
	
	public List<Object> findOldCourses() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return courseDao.findOldCourses();	
	}

	
	public List<Object> findCoursesView() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return courseDao.findCoursesView();	
	}
	
	
	public List<Object> findCoursesView2() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return courseDao.findCoursesView2();	
	}
}
