package com.charvikent.issuetracking.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.NotificationsBean;
import com.charvikent.issuetracking.model.ReportIssue;

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
	
	
	public List<ReportIssue> getTasksTommorrowDeadLine() 
	{
		String sql="select  r.subject,r.taskdeadline,CONCAT(u.firstname,' ',u.lastname) as assignto,CONCAT(u1.firstname,' ',u1.lastname) as assignby,u.mobilenumber  as assigntoid, u1.mobilenumber as assignbyid from report_issue r ,kpusers u , kpusers u1 where   r.assignto = u.id and  r.assignby = u1.id and r.kstatus <> '1' and STR_TO_DATE(r.taskdeadline, '%d-%b-%Y  %k:%i') = CURDATE() + INTERVAL 1 DAY ";
		
		System.out.println(sql);
		
		 RowMapper<ReportIssue> rowMapper = new BeanPropertyRowMapper<ReportIssue>(ReportIssue.class);
		
		List<ReportIssue>  retlist = jdbcTemplate.query(sql,rowMapper);
		System.out.println(retlist);
		return retlist;
	}
	
	
	

}
