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

		String hql ="select  r.id , CONCAT(u.firstname,' ',u.lastname) as username, s.severity as sev, p.priority as pp,r.uploadfile,r.subject ,DATE_FORMAT(r.created_time,'%d - %M -%Y') as date,c.category as cc,ks.name,r.status ,r.taskno ,r.severity as sid, r.priority as pid,r.assignto , r.category as rcid,r.description ,r.taskdeadline,r.assignby,CONCAT(u1.firstname,' ',u1.lastname) as asby ,r.kstatus" 
                    +"from report_issue r, kpcategory c, kppriority p, kpusers u, kpusers u1, kpseverity s, kpstatus ks, kpstatuslogs kpl"    
                    +"where  r.kstatus=ks.id and r.assignto=u.id and r.assignby=u1.id and p.id=r.priority and s.id=r.severity and c.id=r.category   and  kpl.issueid=r.id and r.created_time='2018-07-07'"
                    +"order by kpl.statustime desc";
		
		List<Map<String, Object>> list = template.queryForList(hql);
		
		Set<Map<String, Object>> set =new HashSet<Map<String,Object>>(list);
		
		
		return set;
	}

}
