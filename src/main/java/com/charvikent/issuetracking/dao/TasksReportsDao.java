package com.charvikent.issuetracking.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TasksReportsDao {
	
	@Autowired
	JdbcTemplate template;

	public Set<Map<String, Object>> getTasksByDates(String fromDate, String toDate) {

		String sql ="select  r.id , CONCAT(u.firstname,' ',u.lastname) as username, s.severity as sev, p.priority as pp,r.uploadfile,r.subject ,DATE_FORMAT(r.created_time,'%d - %M -%Y') as date,c.category as cc,ks.name,r.status ,r.taskno ,r.severity as sid, r.priority as pid,r.assignto ,"
                     +" r.category as rcid,r.description ,r.taskdeadline,r.assignby,CONCAT(u1.firstname,' ',u1.lastname) as asby ,r.kstatus "
                   +" from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks, kpstatuslogs kpl  " 
                  +"  where  r.kstatus=ks.id and r.assignto=u.id and r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category   and  kpl.issueid=r.id and date(r.created_time)='2018-07-07' "
                   +" order by kpl.statustime desc";
		
		String sql2 ="select r.id, CONCAT(u.firstname,' ',u.lastname)  as assignto, s.severity,p.priority,r.uploadfile,r.subject,DATE_FORMAT(r.created_time,'%d - %M -%Y') as strcreatedTime,c.category, ks.name as kstatus,r.status,r.taskno, r.description,CONCAT(u1.firstname,' ',u1.lastname) as assignby,r.taskdeadline,nf.frequence_name as notificationsfrequency ,ks.id as kstatusid, r.departmentid,kpd.name as departmentname"      
                     +" from report_issue r,kpusers u,kpusers u1, kppriority p, kpseverity s,kpcategory c, kpstatus ks,notifications_frequency nf,kpdepartment kpd "
                     +" where  r.assignto=u.id and r.assignby=u1.id and  p.id=r.priority and s.id=r.severity and c.id=r.category and r.kstatus=ks.id and nf.id=r.notificationsfrequency and  kpd.id=r.departmentid and Date(r.created_time) >=' "+fromDate+" ' and Date(r.created_time) <=' "+toDate+" ' ";
		
		
		System.out.println(sql2);
		
		List<Map<String,Object>> list = template.queryForList(sql2, new Object[]{});
		
		Set<Map<String, Object>> set =new HashSet<Map<String,Object>>(list);
		
		
		return set;
	}
	
	
	public Set<Map<String, Object>> getAlltasksForReports() {

		
		String sql2 ="select r.id, CONCAT(u.firstname,' ',u.lastname)  as assignto, s.severity,p.priority,r.uploadfile,r.subject,DATE_FORMAT(r.created_time,'%d - %M -%Y') as strcreatedTime,c.category, ks.name as kstatus,r.status,r.taskno, r.description,CONCAT(u1.firstname,' ',u1.lastname) as assignby,r.taskdeadline,nf.frequence_name as notificationsfrequency ,ks.id as kstatusid, r.departmentid,kpd.name as departmentname"      
                     +" from report_issue r,kpusers u,kpusers u1, kppriority p, kpseverity s,kpcategory c, kpstatus ks,notifications_frequency nf,kpdepartment kpd "
                     +" where  r.assignto=u.id and r.assignby=u1.id and  p.id=r.priority and s.id=r.severity and c.id=r.category and r.kstatus=ks.id and nf.id=r.notificationsfrequency and  kpd.id=r.departmentid  ";
		
		
		System.out.println(sql2);
		
		List<Map<String,Object>> list = template.queryForList(sql2, new Object[]{});
		
		Set<Map<String, Object>> set =new HashSet<Map<String,Object>>(list);
		
		
		return set;
	}


	public Set<Map<String, Object>> getTasksByFilter(String assignedbyid, String assignedtoid, String priorityid,
			String categoryid, String deptid, String kstatusid, String fromDate, String toDate) {

		String sql ="select r.id, CONCAT(u.firstname,' ',u.lastname)  as assignto, s.severity,p.priority,r.uploadfile,r.subject,DATE_FORMAT(r.created_time,'%d - %M -%Y') as strcreatedTime,c.category, ks.name as kstatus,r.status,r.taskno, r.description,CONCAT(u1.firstname,' ',u1.lastname) as assignby,r.taskdeadline,nf.frequence_name as notificationsfrequency ,ks.id as kstatusid, r.departmentid,kpd.name as departmentname"      
               +" from report_issue r,kpusers u,kpusers u1, kppriority p, kpseverity s,kpcategory c, kpstatus ks,notifications_frequency nf,kpdepartment kpd "
               +" where  r.assignto=u.id and r.assignby=u1.id and  p.id=r.priority and s.id=r.severity and c.id=r.category and r.kstatus=ks.id and nf.id=r.notificationsfrequency and  kpd.id=r.departmentid  ";
	
		
		if(!assignedbyid.equals("0"))
		{

			sql =sql+" and  r.assignby='"+assignedbyid+" ' " ;
			
		}
		
		if(!assignedtoid.equals("0"))
		{

			
			sql =sql+" and  r.assignto='"+assignedtoid+" ' " ;
			
		}
		
		
		if(!categoryid.equals("0"))
		{
			
			sql =sql+" and  r.priority='"+categoryid+" ' " ;
			
		}
		
		if(!priorityid.equals("0"))
		{
			
			sql =sql+" and  r.category='"+priorityid+" ' " ;
			
		}
		
		if(!deptid.equals("0"))
		{
			
			sql =sql+" and  r.departmentid='"+deptid+" ' " ;
			
		}
		
		if(!kstatusid.equals("0"))
		{
			
			sql =sql+" and  r.kstatus='"+kstatusid+" ' " ;
			
		}
		
		if(!fromDate.equals("0"))
		{
			
			sql =sql+" and Date(r.created_time) =' "+fromDate+" ' " ;
			
		}
		if(!toDate.equals("0"))
		{
			
			sql =sql+"and   Date(r.updated_time) =' "+toDate+" '" ;
			
		}
		
		
		
		
		
		
		
		
		
		String sql2 ="select r.id, CONCAT(u.firstname,' ',u.lastname)  as assignto, s.severity,p.priority,r.uploadfile,r.subject,DATE_FORMAT(r.created_time,'%d - %M -%Y') as strcreatedTime,c.category, ks.name as kstatus,r.status,r.taskno, r.description,CONCAT(u1.firstname,' ',u1.lastname) as assignby,r.taskdeadline,nf.frequence_name as notificationsfrequency ,ks.id as kstatusid, r.departmentid,kpd.name as departmentname"      
                +" from report_issue r,kpusers u,kpusers u1, kppriority p, kpseverity s,kpcategory c, kpstatus ks,notifications_frequency nf,kpdepartment kpd "
                +" where  r.assignto=u.id and r.assignby=u1.id and  p.id=r.priority and s.id=r.severity and c.id=r.category and r.kstatus=ks.id and nf.id=r.notificationsfrequency and  kpd.id=r.departmentid  "
                +"    and r.assignto= '"+assignedtoid+" '  and  r.assignby='"+assignedbyid+" ' and r.category='"+categoryid+" 'and r.priority='"+priorityid+" ' and  r.kstatus='"+kstatusid+"' and r.departmentid='"+deptid+"' " ;
	
	
	System.out.println(sql);
	
	List<Map<String,Object>> list = template.queryForList(sql, new Object[]{});
	
	Set<Map<String, Object>> set =new HashSet<Map<String,Object>>(list);
	return set;
	}


}
