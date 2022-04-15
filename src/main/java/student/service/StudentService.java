package student.service;


import student.dao.StudentDao;
import student.domain.Student;

/**
 * logic functions such as register, login
 * @author Darian Danciu and Amanuel Odicho
 *
 */
public class StudentService {
	private StudentDao studentDao = new StudentDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Student form) throws StudentException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Student student = studentDao.findByStudent_email(form.getStudent_email());
		if(student.getStudent_email()!=null && student.getStudent_email().equals(form.getStudent_email())) throw new StudentException("This office hour already exists!");
		studentDao.add(form);
	}
}