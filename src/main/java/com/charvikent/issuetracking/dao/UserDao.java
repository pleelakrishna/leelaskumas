package com.charvikent.issuetracking.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.Designation;
import com.charvikent.issuetracking.model.OrgDeptHierarchical;
import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.model.UserLogs;

@Repository

public class UserDao {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	JdbcTemplate jdbcTemplate;



	public void saveuser(User user) {
	  // user.setEnabled("1");
		em.persist(user);

	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers()
	{
		List<User> listusers =new ArrayList<User>();


		try {
			List<Object[]> rows = em.createQuery("select  u.id,u.username,u.mobilenumber,u.email,u.reportto,u2.username,CASE WHEN u.enabled IN ('0') THEN 'Deactive' WHEN u.enabled IN ('1') THEN 'Active' ELSE '-----' END AS enabled,dep.name,d.name,"
					+ "u.firstname,u.lastname,u.reportto,u.designation ,u.department , u.enabled as status,u.password,u.kpOrgId ,u.createdTime from User u,User u2,Designation d,Department dep where u.enabled='1' and u.department=dep.id and u.designation= d.id and  u.reportto=u2.id order by u.updatedTime desc").getResultList();
			for (Object[] row : rows) {
				User users =new User();

				users.setId(Integer.parseInt(String.valueOf(row[0])));

				users.setUsername((String) row[1]);
				users.setMobilenumber((String) row[2]);
				users.setEmail((String) row[3]);
				users.setReportto((String) row[4]);
				users.setReportName((String) row[5]);
				users.setEnabled((String) row[6]);
				users.setDepartmentName((String) row[7]);
				users.setDesignationName((String) row[8]);
				users.setFirstname((String) row[9]);
				users.setLastname((String) row[10]);
				users.setReportId((String) row[11]);
				users.setDesignation((String) row[12]);
				users.setDepartment((String) row[13]);
				users.setStatus((String) row[14]);
				users.setPassword((String) row[15]);
				users.setKpOrgId((String) row[16]);
				
				
				listusers.add(users);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return  listusers;
	}


	@SuppressWarnings("unchecked")
	public List<Department> getDepartmentslist()
	{

		return em.createQuery("select department from Department department where status ='1' ").getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Designation> getRoles()
	{

		return em.createQuery("select designation from Designation designation").getResultList();

	}

	public User findWithName(String username,String lpassword) {
		User userbean =null;
		try {
			userbean=  (User) em.createQuery(" select u FROM User u where  enabled='1' and u.username =:custName AND u.password =:custPass ")
					.setParameter("custName", username)
					.setParameter("custPass", lpassword)
					.getSingleResult();

		} catch (Exception e) {
			return userbean;
			//e.printStackTrace();
		}
		return userbean;


	}


	public User getUserById(Integer id) {

		return em.find(User.class, id);
	}

	/*public void deleteUser(Integer id,String enabled) {

		User user=getUserById(id);
		User users= new User();

		//users.setId(id);


		users.setPassword(user.getPassword());
		users.setDepartment(user.getDepartment());
		users.setDesignation(user.getDesignation());
		users.setEmail(user.getEmail());

		if(enabled.equals("Active")) {
			users.setEnabled("0");
			//enabled="0";

		}else {
			users.setEnabled("1");
			//enabled="1";
		}
		//users.setEnabled(user.getEnabled());
		users.setFirstname(user.getFirstname());
		users.setLastname(user.getLastname());
		users.setMobilenumber(user.getMobilenumber());
		users.setUsername(user.getUsername());
		users.setReportto(user.getReportto());

		em.merge(users);

		em.flush();

		String sql="update User u set u.enabled='"+enabled+"' where u.id='"+id+"' ";
		users.setEnabled(user.getEnabled());
		//String sql="update User u set u.enabled=? where u.id=?";

		//Query query = em.createQuery(sql).setParameter("enabled",enabled ).setParameter("id", id);
	Query qry = sessionFactory.;
	qry.setParameter(0,enabled);
	qry.setParameter(1, id);
    int res = qry.executeUpdate();

		//query.executeUpdate();
		String hql = "UPDATE Buchung as b set " +
		          "STORNO = :Storno," +
		          "NAME = :Name " +
		           ......
		          "where ID = :BuchungID";

		Query qr = session.createSQLQuery(hql);

		qr.setParameter("Storno","sto_value");

		qr.setParameter("Name","name_value");

		...

		qr.executeUpdate();

		// int result = em.createQuery("UPDATE User u set u.enabled='\"+enabled+\"' where u.id='\"+id+\"' ").executeUpdate();

	 //User result=

		//em.flush();



	}
*/
	public void updateUser(User user) {
		
		User objuserBean = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		   Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Collection<? extends GrantedAuthority> authorities =authentication.getAuthorities();
			
			
		User users=getUserById(user.getId());
		//users.setPassword(user.getCpassword());
		users.setPassword(user.getPassword());
		users.setDepartment(user.getDepartment());
		users.setDesignation(user.getDesignation());
		users.setEmail(user.getEmail());
		//users.setEnabled(user.getEnabled());
		users.setFirstname(user.getFirstname());
		users.setLastname(user.getLastname());
		users.setMobilenumber(user.getMobilenumber());
		users.setUsername(user.getUsername());
		users.setReportto(user.getReportto());
		
		if(authorities.contains(new SimpleGrantedAuthority("ROLE_MASTERADMIN")))
		{
			users.setKpOrgId(user.getKpOrgId());
		}

		em.merge(users);

		em.flush();


	}

	public void updatePassword(User user) {
		
		em.merge(user);

		em.flush();


	}

	@SuppressWarnings("unchecked")
	public List<User> getUserNames()
	{

		return em.createQuery("SELECT user FROM User user").getResultList();

	}


	public User find(Integer id) {

		return em.find(User.class, id);

	}

	public void setLoginRecord(Integer id,String str) {
		UserLogs logs =new UserLogs();
		logs.setUserid(String.valueOf(id));
		logs.setSessionname(str);
		em.merge(logs);

	}

	public List<String> getUsersUnderReportTo(String rto)
	{
		List<String> list1=new ArrayList<String>();
		@SuppressWarnings("unchecked")
		List<Object []> rowsf =   em.createNativeQuery("select  id,reportto from(select * from kpusers order by reportto, id) kpusers_sorted,(select @pv \\:=:custName ) initialisation where   find_in_set(reportto, @pv) > 0 and     @pv \\:= concat(@pv, ',', id)").setParameter("custName",rto).getResultList();
		for(Object[] row:rowsf)
		{
			list1.add(String.valueOf(row[0]));
		}
		return list1;
	}

	public static Set<String> parents=new TreeSet<String>();

	@SuppressWarnings("unchecked")
	public void getAllParents(String id)
	{
         List<Object []> rowsf =   em.createNativeQuery("SELECT T2.id,T2.username FROM (SELECT @r AS _id, (SELECT @r \\:= reportto FROM kpusers WHERE id = _id) AS reportto, @l \\:= @l + 1 AS lvl FROM (SELECT @r \\:=:custName, @l \\:= 0) vars,kpusers h WHERE   @r <> 0) T1 JOIN kpusers T2 ON T1._id = T2.id ORDER BY T1.lvl DESC").setParameter("custName",id).getResultList();
         for(Object[] row:rowsf)
 		{
 			parents.add(String.valueOf(row[0]));
 		}

	}


	public boolean deleteUser(Integer id, String status) {
		Boolean delete=false;
		try{

			User design= em.find(User.class ,id);
			   design.setEnabled(status);
			   em.merge(design);
			if(!status.equals(design.getEnabled()))
			{
				delete=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return delete;
	}

	@SuppressWarnings("unchecked")
	public User findByUserName(String userName)
	{
		/*User user= (User) em.createQuery("select user from User user where username=:Custname").setParameter("Custname", userName).getSingleResult();
		System.out.println(user);*/
		
		
		String hql ="From User where   enabled ='1' and  username= '"+userName+"' ";
		
		Query query = em.createQuery(hql);
		
		
		List<User> list =query.getResultList();
		
		       if(list.size() >0)
		       {
		    	   return list.get(0);
		       }
		       else
		       return null;
		
		
		
	}
	@SuppressWarnings("unchecked")
	public List<String> findRoleByUserName(String Username)
	{
		//List<String> list= em.createNativeQuery("SELECT d.name FROM  kpusers u,kpdesignation d,kpmultiroles m  where u.designation=d.id  and k.username=:Custname").setParameter("Custname", Username).getResultList();
		//List<String> list= em.createNativeQuery("select m.desigrole from kpusers u,kpdesignation d,kpmultiroles m  where u.designation=d.id and m.designationid=u.designation and u.username =:Custname").setParameter("Custname", Username).getResultList();
		List<String> list= em.createNativeQuery("select m.desigrole from kpusers u,kpmultiroles m  where  m.designationid=u.designation and u.username =:Custname").setParameter("Custname", Username).getResultList();


		System.out.println(list);
		return list;


	}

	public User getUserByObject(User user) {

		String hql ="from User where username =:n or mobilenumber =:m ";

		Query query =em.createQuery(hql);
		query.setParameter("n", user.getUsername());
		query.setParameter("m", user.getMobilenumber());

		List<User>usersList =query.getResultList();
		if(usersList.isEmpty())
               return null;
               else
		return usersList.get(0);
	}


	@SuppressWarnings("unchecked")
	public List<User> getInActiveList() {
		// TODO Auto-generated method stub
		//return em.createQuery(" from User where enabled='0'").getResultList();

		List<User> listusers =new ArrayList<User>();


		try {
			List<Object[]> rows = em.createQuery("select  u.id,u.username,u.mobilenumber,u.email,u.reportto,u2.username,dep.name,d.name,"
					+ "u.firstname,u.lastname,u.reportto,u.designation ,u.department , u.enabled as status from User u,User u2,Designation d,Department dep where u.enabled='0' and u.department=dep.id and u.designation= d.id and  u.reportto=u2.id").getResultList();
			for (Object[] row : rows) {
				User users =new User();

				users.setId(Integer.parseInt(String.valueOf(row[0])));

				users.setUsername((String) row[1]);
				users.setMobilenumber((String) row[2]);
				users.setEmail((String) row[3]);
				users.setReportto((String) row[4]);
				users.setReportName((String) row[5]);
				//users.setEnabled((String) row[6]);
				users.setDepartmentName((String) row[6]);
				users.setDesignationName((String) row[7]);
				users.setFirstname((String) row[8]);
				users.setLastname((String) row[9]);
				users.setReportId((String) row[10]);
				users.setDesignation((String) row[11]);
				users.setDepartment((String) row[12]);
				users.setStatus((String) row[13]);
				listusers.add(users);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return  listusers;
		 	}

	public User getUserDesignationById(Integer id) {
		String hql ="select  ku.username, kd.name from kpdesignation kd,kpusers ku where ku.designation=kd.id and ku.id=:id ";
		User users =new User();
		try{
			
			List<Object[]> rows = em.createNativeQuery(hql).setParameter("id", id).getResultList();
			
		for (Object[] row : rows) {
			
			users.setUsername((String) row[0]);
			users.setDesignationName((String) row[1]);
					
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return  users;
	}



	
	public User getUsersById(Integer id) {
		
		String sql = "SELECT * FROM kpusers  WHERE id = "+id;
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);	
		User user = jdbcTemplate.queryForObject(sql, rowMapper);
		return user;
		

		
	}

	public List<OrgDeptHierarchical> getEmployessForChart() {
		String sql = "SELECT  CONCAT(firstname, ' ',lastname)  as name,id,reportto as parent from kpusers ";
		RowMapper<OrgDeptHierarchical> rowMapper = new BeanPropertyRowMapper<OrgDeptHierarchical>(OrgDeptHierarchical.class);	
		List<OrgDeptHierarchical> user = jdbcTemplate.query(sql, rowMapper);
		return user;
		
	}

	public void saveKumarLogin(User user) {
		java.sql.Timestamp Date = 
				new java.sql.Timestamp(new Date().getTime()); 
		String hql ="INSERT INTO login (created_time,userName,password,roleId,status,branchId,empId) VALUES ( '"+Date+"' , '"+user.getUsername()+"' ,'"+user.getPassword()+"','4','1','"+user.getDepartment()+"','"+user.getId()+"') ";
		
		System.out.println(hql);
		jdbcTemplate.update(hql);
			
		
	}
	
	
	public void saveKumarEmployeeLogin(User user) {
		
		
		String name = user.getFirstname()+" "+user.getLastname();
		
		java.sql.Timestamp Date = 
				new java.sql.Timestamp(new Date().getTime()); 
		String hql ="INSERT INTO kumar_employee (id,created_time,name,email,userName,password,roleId,status,branch_id,phone_number) VALUES ( "+user.getId()+" ,'"+Date+"' , '"+name+"' ,'"+user.getEmail()+"' ,'"+user.getUsername()+"' ,'"+user.getPassword()+"','4','1','"+user.getDepartment()+"','"+user.getMobilenumber()+"') ";
		
		System.out.println(hql);
		
		jdbcTemplate.update(hql);
			
		
	}


	
public void editKumarEmployeeLogin(User user) {
		
		
		String name = user.getFirstname()+" "+user.getLastname();
		
		java.sql.Timestamp Date = 
				new java.sql.Timestamp(new Date().getTime()); 
		//String hql ="INSERT INTO kumar_employee (id,created_time,name,email,userName,password,roleId,status,branch_id,phone_number) VALUES ( "+user.getId()+" ,'"+Date+"' , '"+name+"' ,'"+user.getEmail()+"' ,'"+user.getUsername()+"' ,'"+user.getPassword()+"','4','1','"+user.getDepartment()+"','"+user.getMobilenumber()+"') ";
		
		String  hql ="update kumar_employee set name ='"+name+"',email ='"+user.getEmail()+"',roleId='4',branch_id='"+user.getDepartment()+"',phone_number='"+user.getMobilenumber()+"',roleId='"+user.getDesignation()+"' where id= "+user.getId();  
		
		
		System.out.println(hql);
		
		jdbcTemplate.update(hql);
			
		
	}

public void updateKumarLogin(User user) {
	java.sql.Timestamp Date = 
			new java.sql.Timestamp(new Date().getTime()); 
	String hql ="update login set roleId='"+user.getDesignation()+"',branchId='"+user.getDepartment()+"' where empId ="+user.getId();
	
	System.out.println(hql);
	jdbcTemplate.update(hql);
		
	
}

public void deleteKumarEmployee(Integer id, String enabled) {
	String  hql ="update kumar_employee  set status='"+enabled+"' where id ="+id;
	
	
	System.out.println(hql);
	
	jdbcTemplate.update(hql);
	
}

public void deleteKumarlogin(Integer id, String enabled) {
String hql ="update login set status='"+enabled+"' where empId ="+id;
	
	System.out.println(hql);
	jdbcTemplate.update(hql);
		
	
}

public void changePasswordKumarLogin(User user) {
String hql ="update login set password='"+user.getPassword()+"' where empId ="+user.getId();
	
	System.out.println(hql);
	jdbcTemplate.update(hql);
	
}

public void changePasswordkumarEmployee(User user) {
String hql ="update kumar_employee set password='"+user.getPassword()+"' where id="+user.getId();
	
	System.out.println(hql);
	jdbcTemplate.update(hql);
	
}


}
