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

import com.niit.backend.Dao.CartItemsDao;
import com.niit.backend.model.BillingAddress;
import com.niit.backend.model.CartItem;
import com.niit.backend.model.Supplier;



@Repository("cartitemsDao")
@EnableTransactionManagement
@Transactional
public class CartItemsDaoImpl implements CartItemsDao 
{
  @Autowired
  private SessionFactory sessionFactory ;

	 public CartItemsDaoImpl(SessionFactory sessionFactory)
	 {
		 this.sessionFactory = sessionFactory;
	 }

	public boolean saveorupdate(CartItem cartItem) 
	{
		try{
		   sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
		   return true;
	}
	catch (Exception e)
	{
		e.printStackTrace();
		return false;
	}
	}

	public boolean delete(CartItem id) {
//		CartItem c =new CartItem();
//		c.setCartItem_Id(id);
		sessionFactory.getCurrentSession().delete(id);
		return true;
	}

	public boolean deletebyId(String id) {
		CartItem c =new CartItem();
		c.setCartItem_Id(id);
		sessionFactory.getCurrentSession().delete(id);
		return true;
	}
	
	public CartItem get(String id) {
		String q1="from CartItem where CartItem_Id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<CartItem>list=(List<CartItem>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
	
		
		return list.get(0);
		
	}
	
	@Transactional
	public List<CartItem> getlist(String  cart_Id) {
		String Sql= "From CartItem where Cart_Id='"+cart_Id+"'";
		Query q1= sessionFactory.getCurrentSession().createQuery(Sql);
		@SuppressWarnings("unchecked")
		List<CartItem> list=(List<CartItem>) q1.list();
		if(list==null || list.isEmpty()){
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list;
		}
	}

	public List<CartItem> list() {
		List<CartItem> cartItem=(List<CartItem>)
				sessionFactory.getCurrentSession().createCriteria(CartItem.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		
		return cartItem;
	}


	@Transactional
	public CartItem getlistall(String CartId, String pro) {
		String sql= "from CartItem where Cart_Id='" +CartId+ "'and P_Id ='" +pro+ "'";
		Query q1= sessionFactory.getCurrentSession().createQuery(sql);
		@SuppressWarnings("unchecked")
		List<CartItem> list=(List<CartItem>) q1.list();
		if(list==null || list.isEmpty()){
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list.get(0);
		}
	
	}
	@Transactional
	public List<CartItem> getlistbyproId(String p_id) {
		String Sq= "From CartItem  where P_Id='"+p_id+"'";
		Query q= sessionFactory.getCurrentSession().createQuery(Sq);
		@SuppressWarnings("unchecked")
		List<CartItem> list=(List<CartItem>) q.list();
		if(list== null || list.isEmpty()){
			return null;
		}
		else
		{
			return list;
		}
	}
}
