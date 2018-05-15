package com.charvikent.issuetracking.dao;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.NotificationsBean;

@Repository
@Transactional
public class NotificationsDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<NotificationsBean> getDailyNotifications() 
	{
		String sql="select r.id,r.taskno,r.taskdeadline,r.assignto,u.username,u.mobilenumber ,u.email from report_issue r,kpusers u  where  r.assignto = u.id and r.kstatus <> '1' and r.notificationsfrequency ='2' and datediff(Date(STR_TO_DATE(r.taskdeadline, '%d-%M-%Y %H:%i')),date(r.created_time))>0 ";
		
		System.out.println(sql);
		
		 RowMapper<NotificationsBean> rowMapper = new BeanPropertyRowMapper<NotificationsBean>(NotificationsBean.class);
		
		List<NotificationsBean>  retlist = jdbcTemplate.query(sql,rowMapper);
		System.out.println(retlist);
		return retlist;
	}
	
	

	public List<NotificationsBean> getweeklyNotifications() 
	{
		String sql="select r.id,r.taskno,r.taskdeadline,r.assignto,u.username,u.mobilenumber ,u.email from report_issue r,kpusers u  "
                    +" where  r.assignto = u.id and r.kstatus <> '1' and r.notificationsfrequency ='3' and datediff(Date(STR_TO_DATE(r.taskdeadline, '%d-%M-%Y %H:%i')),date(r.created_time))%7=0 ";
		
		System.out.println(sql);
		
		 RowMapper<NotificationsBean> rowMapper = new BeanPropertyRowMapper<NotificationsBean>(NotificationsBean.class);
		
		List<NotificationsBean>  retlist = jdbcTemplate.query(sql,rowMapper);
		System.out.println(retlist);
		return retlist;
	}
	
	
	public List<NotificationsBean> getBiWeeklyNotifications() 
	{
		String sql="select r.id,r.taskno,r.taskdeadline,r.assignto,u.username,u.mobilenumber ,u.email from report_issue r,kpusers u  "
                    +" where  r.assignto = u.id and r.kstatus <> '1' and r.notificationsfrequency ='4' and datediff(Date(STR_TO_DATE(r.taskdeadline, '%d-%M-%Y %H:%i')),date(r.created_time))%15=0 ";
		
		System.out.println(sql);
		
		 RowMapper<NotificationsBean> rowMapper = new BeanPropertyRowMapper<NotificationsBean>(NotificationsBean.class);
		
		List<NotificationsBean>  retlist = jdbcTemplate.query(sql,rowMapper);
		System.out.println(retlist);
		return retlist;
	}
	
	public List<NotificationsBean> getMonthlyNotifications() 
	{
		String sql="select r.id,r.taskno,r.taskdeadline,r.assignto,u.username,u.mobilenumber ,u.email from report_issue r,kpusers u  "
                    +" where  r.assignto = u.id and r.kstatus <> '1' and r.notificationsfrequency ='5' and datediff(Date(STR_TO_DATE(r.taskdeadline, '%d-%M-%Y %H:%i')),date(r.created_time))%30=0 ";
		
		System.out.println(sql);
		
		 RowMapper<NotificationsBean> rowMapper = new BeanPropertyRowMapper<NotificationsBean>(NotificationsBean.class);
		
		List<NotificationsBean>  retlist = jdbcTemplate.query(sql,rowMapper);
		System.out.println(retlist);
		return retlist;
	}
	
	
	

}
