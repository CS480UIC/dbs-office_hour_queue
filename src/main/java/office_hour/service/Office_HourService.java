package office_hour.service;


import java.util.List;

import office_hour.dao.Office_HourDao;
import office_hour.domain.Office_Hour;

/**
 * @author Aayush Makharia
 *
 */
public class Office_HourService {
	private Office_HourDao office_hourDao = new Office_HourDao();
	
	/**
	 * register an office hour
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Office_Hour form) throws Office_HourException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Office_Hour office_hour = office_hourDao.findById_OH(form.getId_office_hour());
		if(office_hour.getId_office_hour()!=null && office_hour.getId_office_hour() == form.getId_office_hour()) throw new Office_HourException("This user name has been registered!");
		office_hourDao.add(form);
	}
	
	public List<Object> findOldOffice_hours() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return office_hourDao.findOldOffice_hours();
	}
	
	
	public List<Object> findOfficeHourView() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return office_hourDao.findOfficeHourView();
	}
}
