package queue.service;


import queue.domain.Queue;

import java.util.List;

import queue.dao.QueueDao;

/**
 * @author Aayush Makharia
 *
 */
public class QueueService {
	private QueueDao queueDao = new QueueDao();
	
	/**
	 * register an office hour
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Queue form) throws QueueException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Queue queue = queueDao.findById_OH(form.getId_queue());
		if(queue.getId_queue()!=null && queue.getId_queue() == form.getId_queue()) throw new QueueException("This queue already exists!");
		queueDao.add(form);
	}
	
	public List<Object> findOldQueues() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return queueDao.findOldQueues();
		
	}
}
