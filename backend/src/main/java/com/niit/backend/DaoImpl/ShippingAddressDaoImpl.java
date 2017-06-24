package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.ShippingAddress;
import com.niit.backend.Dao.ShippingAddressDao;



@Repository("shippingAddressDao")
@EnableTransactionManagement
@Transactional
public class ShippingAddressDaoImpl implements ShippingAddressDao {
	@Autowired
	SessionFactory sessionFactory;
	public ShippingAddressDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean saveorupdate(ShippingAddress shipingAddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(shipingAddress);
		return true;
	}

	@Transactional
	public boolean delete(ShippingAddress shipingAddress) {
		sessionFactory.getCurrentSession().delete(shipingAddress);
		return true;
	}

	@Transactional
	public ShippingAddress get(String id) {
		String q1="from ShippingAddress where Ship_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<ShippingAddress>list =(List<ShippingAddress>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Transactional
	public List<ShippingAddress> getaddbyuser(String u_id) {
		String q1 ="from ShippingAddress where u_id='"+u_id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<ShippingAddress> list = (List<ShippingAddress>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list;
		}
	
	@Transactional
	public List<ShippingAddress> list() {
		
		List<ShippingAddress> shipingAddress=(List<ShippingAddress>)
				sessionFactory.getCurrentSession().createCriteria(ShippingAddress.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		
		return shipingAddress;
	}

}
