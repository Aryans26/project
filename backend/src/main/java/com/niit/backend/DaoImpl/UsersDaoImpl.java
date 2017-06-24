package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.UsersDao;
import com.niit.backend.model.Users;
import com.niit.backend.model.Authentication;
import com.niit.backend.model.BillingAddress;
import com.niit.backend.model.Cart;

@Repository("usersDao")
@EnableTransactionManagement
@Transactional

public class UsersDaoImpl implements UsersDao {
	@Autowired
	SessionFactory sessionFactory;
	public UsersDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional//when ever user says to save the data it will perform that action
	public boolean saveorupdate(Users users) {
		Authentication authentication=new Authentication();
		authentication.setUsername(users.getU_email());
		BillingAddress billingAddress = new BillingAddress();
		Cart cart = new Cart();
		users.setBillingAddress(billingAddress);
		users.setCart(cart);
		users.getBillingAddress().setUser(users);
		users.getBillingAddress().setPhone(users.getU_phoneno());
		users.getBillingAddress().setEmail(users.getU_email());
		sessionFactory.getCurrentSession().saveOrUpdate(users.getBillingAddress());
		 System.out.println("\t Billing is SaveorUpdate ");
//		sessionFactory.getCurrentSession().saveOrUpdate(users);
		sessionFactory.getCurrentSession().saveOrUpdate(users.getCart());
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		 System.out.println("\t Billing is authentiation ");
		sessionFactory.getCurrentSession().saveOrUpdate(users);
		 System.out.println("\t Billing is SaveorUpdate user ");
		return true;
	}

	@Transactional
	public boolean delete(String users) {
		 Users u =new Users();
		   u.setU_id(users);;
	  sessionFactory.getCurrentSession().delete(users);
		return true;
	}

	@Transactional
	public Users get(String id) {
		String q1="from Users where U_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Users>list =(List<Users>) w.list();//typecasting
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Transactional
	public List<Users> list() {
		List<Users> users=(List<Users>)
				sessionFactory.getCurrentSession().createCriteria(Users.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return users;
	}
	
	@Transactional
	public Users getUseremail(String email)
	{
		String q1="From Users where U_email='"+email+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Users>list=(List<Users>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}
	
	@Transactional
	public Users isvalid(String email,String password)
	{
		String q1="from Users where U_email='"+email+"'and U_pwd='"+password+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Users>list=(List<Users>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

}
