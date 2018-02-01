package com.charvikent.issuetracking.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.Designation;
import com.charvikent.issuetracking.model.User;
import com.charvikent.issuetracking.model.UserLogs;

@Repository

public class UserDao {

	@PersistenceContext
	private EntityManager em;

	public void saveuser(User user) {
		em.persist(user);

	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers()
	{
		List<User> listusers =new ArrayList<User>();


		try {
			List<Object[]> rows = em.createQuery("select  u.id,u.username,u.mobilenumber,u.email,u.enabled,dep.name,d.name,"
					+ "u.firstname,u.lastname,u.reportto,u.designation ,u.department  from User u,Designation d,Department dep where u.department=dep.id and u.designation= d.id").getResultList();
			for (Object[] row : rows) {
				User users =new User();

				users.setId(Integer.parseInt(String.valueOf(row[0])));

				users.setUsername((String) row[1]);
				users.setMobilenumber((String) row[2]);
				users.setEmail((String) row[3]);
				users.setEnabled((Boolean) row[4]);
				users.setDepartmentName((String) row[5]);
				users.setDesignationName((String) row[6]);
				users.setFirstname((String) row[7]);
				users.setLastname((String) row[8]);
				users.setReportId((String) row[9]);
				users.setDesignation((String) row[10]);
				users.setDepartment((String) row[11]);

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

		return em.createQuery("select department from Department department").getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<Designation> getRoles()
	{

		return em.createQuery("select designation from Designation designation").getResultList();

	}

	public User findWithName(String username,String lpassword) {
		User userbean =null;
		try {
			userbean=  (User) em.createQuery(" select u FROM User u where  enabled=true and u.username =:custName AND u.password =:custPass ")
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

	public void deleteUser(Integer id) {

		em.remove(getUserById(id));
	}

	public void updateUser(User user) {
		User users=getUserById(user.getId());
		users.setPassword(user.getCpassword());
		users.setDepartment(user.getDepartment());
		users.setDesignation(user.getDesignation());
		users.setEmail(user.getEmail());
		users.setEnabled(user.getEnabled());
		users.setFirstname(user.getFirstname());
		users.setLastname(user.getLastname());
		users.setMobilenumber(user.getMobilenumber());
		users.setUsername(user.getUsername());
		users.setReportto(user.getReportto());

		em.merge(users);

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







}
