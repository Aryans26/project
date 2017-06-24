package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.CartDao;
import com.niit.backend.model.Cart;



@Repository(value="cartDao")
@EnableTransactionManagement
public class CartDaoImpl implements CartDao {
	@Autowired
	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional//when ever user says to save the data it will perform that action
	public boolean saveorupdate(Cart cart) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
		}
		catch (Exception e)
		{
		e.printStackTrace();
		return false;
		}
	}

	@Transactional
	public boolean delete(Cart cart) {
	  sessionFactory.getCurrentSession().delete(cart);
		return true;
	}

	@Transactional
	public Cart get(String id) {
		String q1="from Cart where Cart_Id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Cart>list =(List<Cart>) w.list();//typecasting
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Transactional
	public List<Cart> list() {
		List<Cart> cart=(List<Cart>)
				sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return cart;
	}


}
