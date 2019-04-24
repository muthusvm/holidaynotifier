package com.svmrm.notify.HolidayNotify.dao;

import java.sql.Date;
import java.util.List;

import com.svmrm.notify.HolidayNotify.model.HolidayMaster;

public interface HolidayDAO {
	
	public List<HolidayMaster> getHoliday(String date);
	public List<HolidayMaster> getHolidaybyMonth(String month, String year);

}
