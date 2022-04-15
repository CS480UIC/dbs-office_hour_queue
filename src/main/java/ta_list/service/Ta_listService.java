package ta_list.service;


import ta_list.dao.Ta_listDao;
import ta_list.domain.Ta_list;

/**
 * logic functions such as register, login
 * @author Darian Danciu and Amanuel Odicho
 *
 */
public class Ta_listService {
	private Ta_listDao ta_listDao = new Ta_listDao();
	
	/**
	 * register a Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Ta_list form) throws Ta_listException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Ta_list ta_list = ta_listDao.findByTa_email(form.getTa_email());
		if(ta_list.getTa_email()!=null && ta_list.getTa_email().equals(form.getTa_email())) throw new Ta_listException("This ta_list already exists!");
		ta_listDao.add(form);
	}
}
