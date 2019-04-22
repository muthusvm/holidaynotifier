package com.svmrm.notify.HolidayNotify;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.svmrm.notify.HolidayNotify.dao.HolidayDAO;
import com.svmrm.notify.HolidayNotify.dao.HolidayDAOImpl;
import com.svmrm.notify.HolidayNotify.model.HolidayMaster;

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
        
    	String strDate = "01/05/2019";
    	/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date;
		try {
			date = sdf.parse(strDate);
			java.sql.Date sqlDate = new Date(date.getTime());*/
	    List<HolidayMaster>  holidayMasters=   playerDAO.getHoliday(strDate);
	    
	    for (HolidayMaster holidayMaster : holidayMasters) {
	    	
	    	System.out.println("Code :"+ holidayMaster.getAreaCode());
	    	System.out.println("Name :"+ holidayMaster.getAreaName());
	    	System.out.println("Id "+holidayMaster.getId());
	    	System.out.println("Date "+holidayMaster.getHolidayDate());
	    	System.out.println("Type  "+holidayMaster.getHolidayType());
	    	System.out.println("Desc "+holidayMaster.getHolidayDesc());


			
		}

		/*} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
        
 
    }
}
