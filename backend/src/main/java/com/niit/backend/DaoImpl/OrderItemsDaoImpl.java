package com.niit.backend.DaoImpl;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

//import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.OrderItemsDao;
import com.niit.backend.model.CartItem;
import com.niit.backend.model.Order;
import com.niit.backend.model.OrderItems;


@Repository("orderitemsDao")
@EnableTransactionManagement
@Transactional
public class OrderItemsDaoImpl implements OrderItemsDao 
{
  @Autowired
  private SessionFactory sessionFactory ;

	 public OrderItemsDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory = sessionFactory;
	 }


	public boolean saveorupdate(OrderItems orderItems) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(orderItems);
		return true;
	}

	public boolean delete(OrderItems orderItems) {
		
		sessionFactory.getCurrentSession().delete(orderItems);
		return true;
	}

	public OrderItems get(String id) {
		String q1="from OrderItems where OrderItem_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<OrderItems>list =(List<OrderItems>) w.list();//typecasting
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}
	
	@Transactional
	public List<OrderItems> getOrderItemsbyOrder(String order_id) {
		String q1 ="from OrderItems where order_id='"+order_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<OrderItems> list = (List<OrderItems>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
	}

	public List<OrderItems> list() {
		List<OrderItems> orderItems=(List<OrderItems>)
				sessionFactory.getCurrentSession().createCriteria(OrderItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		
		return orderItems;
	}

}
