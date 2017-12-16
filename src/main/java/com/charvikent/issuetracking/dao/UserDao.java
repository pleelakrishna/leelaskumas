package com.charvikent.issuetracking.dao;

import java.util.List;
import java.util.jar.Attributes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charvikent.issuetracking.model.Department;
import com.charvikent.issuetracking.model.Designation;
import com.charvikent.issuetracking.model.User;

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
	 return (List<User>) em.createQuery("select user from User user").getResultList();
 }
 

@SuppressWarnings("unchecked")
public List<Department> getDepartmentslist()
 {
	  
	return (List<Department>)em.createQuery("select department from Department department").getResultList();
	 
 }

@SuppressWarnings("unchecked")
public List<Designation> getRoles()
 {
	  
	return (List<Designation>)em.createQuery("select designation from Designation designation").getResultList();
	 
 }

public User findWithName(String username,String lpassword) {
	User userbean =null;
        try {
		 userbean=  (User) em.createQuery(" select u FROM User u where u.username =:custName AND u.password =:custPass ")
			.setParameter("custName", username)
			.setParameter("custPass", lpassword)
			.getSingleResult();
     /*  System.out.println(userbean);
   if(userbean.size()>0){
			return userbean.get(0);
   }else{*/
			
			
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
	
	em.merge(users);
	/*users.setLastname(user.getLastname());
	users.setDepartment(user.getDepartment());
	users.setDesignation(user.getDesignation());
	users.setEmail(user.getEmail());
	users.setEnabled(user.getEnabled());
	users.setFirstname(user.getFirstname());
	users.setMobilenumber(user.getMobilenumber());
	users.setUsername(user.getUsername());
	users.setPassword(user.getPassword());*/
	
	em.flush();
	
	
}

@SuppressWarnings("unchecked")
public List<User> getUserNames()
 {
	  
	return (List<User>)em.createQuery("SELECT user FROM User user").getResultList();
	 
 }


public User find(Integer id) {

	  return em.find(User.class, id);

	 }

/*@SuppressWarnings("unchecked")
public List<Admin> getAdminNames()
 {
	  
	return (List<Admin>)em.createQuery("SELECT admin FROM Admin admin").getResultList();
	 
 }
*/


}
