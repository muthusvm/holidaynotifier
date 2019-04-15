package com.svmrm.notify.HolidayNotify.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.svmrm.notify.HolidayNotify.model.HolidayMaster;

public class HolidayDAOImpl implements HolidayDAO {
		
		@Autowired
		private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

	public List<HolidayMaster> getHoliday(Date date) {
		// TODO Auto-generated method stub
			String query="select id,area_code,area_name,holiday_date,holiday_descryption,holiday_type from travels_area_holiday_master where holiday_date=?";
			List<HolidayMaster> holidayMasters=	getJdbcTemplate().query(query, new Object[]{date},new BeanPropertyRowMapper(HolidayMaster.class));
			return holidayMasters;
	
	}

}
