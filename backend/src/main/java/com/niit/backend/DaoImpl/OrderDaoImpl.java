package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.OrderDao;
import com.niit.backend.model.Order;

@Repository(value="orderDao")
@EnableTransactionManagement
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	public OrderDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional//when ever user says to save the data it will perform that action
	public boolean saveorupdate(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}

	@Transactional
	public boolean delete(Order order) {
	  sessionFactory.getCurrentSession().delete(order);
		return true;
	}

	@Transactional
	public Order get(String id) {
		String q1="from Order where Order_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
//		@SuppressWarnings("resources")
		List<Order>list =(List<Order>) w.list();//typecasting
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Transactional
	public List<Order> list() {
		List<Order> order=(List<Order>)
				sessionFactory.getCurrentSession().createCriteria(Order.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return order;
	}


}
