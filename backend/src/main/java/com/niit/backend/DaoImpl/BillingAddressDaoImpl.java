package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.BillingAddressDao;
import com.niit.backend.model.BillingAddress;



@Repository(value="billingAddressDao")
@EnableTransactionManagement
public class BillingAddressDaoImpl implements BillingAddressDao {
	@Autowired
	SessionFactory sessionFactory;
	public BillingAddressDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}

	@Transactional
	public boolean saveorupdate(BillingAddress billingAddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);
		return true;
	}

	@Transactional
	public boolean delete(BillingAddress billingAddress) {
		sessionFactory.getCurrentSession().delete(billingAddress);

		return true;
	}

	@Transactional
	public BillingAddress get(String id) {
		String q1="from BillingAddress where Bill_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<BillingAddress>list =(List<BillingAddress>) w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}
	@Transactional
	public BillingAddress getByUser(String u_Id)
	{
		String q1 ="from BillingAddress where U_ID='"+u_Id+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<BillingAddress> list = (List<BillingAddress>) w.list();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Transactional
	public List<BillingAddress> list() {
		List<BillingAddress> billingAddress=(List<BillingAddress>)
				sessionFactory.getCurrentSession().createCriteria(BillingAddress.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		
		return billingAddress;
	}
	
	

}