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
        HolidayDAOImpl holidayDAO = (HolidayDAOImpl) applicationContext.getBean("holidayDAOImpl");
        
    	String strDate = "01/05/2019";
    	/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date;
		try {
			date = sdf.parse(strDate);
			java.sql.Date sqlDate = new Date(date.getTime());*/
    	
	    List<HolidayMaster>  holidayMasters= holidayDAO.getHolidaybyMonth("05", "2019"); // holidayDAO.getHoliday(strDate);
	    
	    		StringBuilder htmlcontent=new StringBuilder();
	    	    StringBuilder tr=new StringBuilder();
	    for (HolidayMaster holidayMaster : holidayMasters) {
	    		tr.append("<tr>");
	    		tr.append("<td>"+holidayMaster.getHolidayDate()+"</td>");
	    		tr.append("<td>"+holidayMaster.getAreaName()+"</td>");
	    		tr.append("<td>"+holidayMaster.getHolidayType()+"</td>");
	    		tr.append("<td>"+holidayMaster.getHolidayDesc()+"</td>");
	    		tr.append("</tr>");


	    	System.out.println("Code :"+ holidayMaster.getAreaCode());
	    	System.out.println("Name :"+ holidayMaster.getAreaName());
	    	System.out.println("Id "+holidayMaster.getId());
	    	System.out.println("Date "+holidayMaster.getHolidayDate());
	    	System.out.println("Type  "+holidayMaster.getHolidayType());
	    	System.out.println("Desc "+holidayMaster.getHolidayDesc());
	    	
	    	
			
		}
	    
	    if(holidayMasters!=null && holidayMasters.size()>1){
	    	String subject="List of holiday for the month of May 2019.";
	    		String header="<p>Dear Team, <br> please find the "+ subject+" </p>";
	    	String footer="<p>Regards,<br> Holiday Notifier Team, <br> Chennai-100. </p>";
	    	
	    	htmlcontent.append("<html>");
	    	htmlcontent.append("<body>");
	    	StringBuilder table=new StringBuilder();
	    	table.append("<table border='1'>");
	    	table.append("<tr><th>Holiday Date</th><th>Area Name</th><th>Holiday Type</th><th>Holiday Description</th></tr>");
	    	table.append(tr);
	    	table.append("</table>");
	    	
	    	htmlcontent.append(header);
	    	htmlcontent.append(table);
	    	htmlcontent.append(footer);

	    	htmlcontent.append("</body>");
	    	htmlcontent.append("</html>");
	    	
	    	System.out.println("htmlcontent "+htmlcontent);
	    	
	    }

	    
	    

		
 
    }
}
