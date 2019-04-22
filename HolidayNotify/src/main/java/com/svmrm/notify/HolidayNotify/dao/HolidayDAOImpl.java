package com.svmrm.notify.HolidayNotify.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.svmrm.notify.HolidayNotify.model.HolidayMaster;

public class HolidayDAOImpl implements HolidayDAO {
		
		private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

	public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

	public List<HolidayMaster> getHoliday(String date) {
		// TODO Auto-generated method stub
		//List holidayMasters=null;
		List<HolidayMaster> holidayMasters =null;
		try{
			System.out.println("Test");
			String query="select id,area_code,area_name,holiday_date,holiday_desc,holiday_type from TEST_HM where trunc(holiday_date)=TO_DATE('"+date+"', 'DD/MM/YYYY')";
			//String query="select h_id,area_code,area_name,holiday_date,holiday_descryption,holiday_type from TEST_HM ";
			 holidayMasters=	getJdbcTemplate().query(query, new BeanPropertyRowMapper(HolidayMaster.class));
			//List holidayMasters=	getJdbcTemplate().queryForList(query, new Object[]{date});
			 ///holidayMasters=(List)	getJdbcTemplate().queryForList(query );

		}catch(Exception e){
			e.printStackTrace();
		}
			return holidayMasters;
	
	}

}
