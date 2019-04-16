package com.svmrm.notify.HolidayNotify;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.svmrm.notify.HolidayNotify.dao.HolidayDAO;
import com.svmrm.notify.HolidayNotify.dao.HolidayDAOImpl;

/**
 * Hello world!
 *
 */
public class App 

{
	
		private HolidayDAOImpl holidayDAOImpl;
	
	
    public HolidayDAOImpl getHolidayDAOImpl() {
		return holidayDAOImpl;
	}
    
    


	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        // loads the context xml and uses getBean() to retrieve the bean
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/svmrm/notify/HolidayNotify/springconfig.xml");
        HolidayDAOImpl playerDAO = (HolidayDAOImpl) applicationContext.getBean("holidayDAOImpl");
        playerDAO.getHoliday(new Date(1000l));
 
    }
}
