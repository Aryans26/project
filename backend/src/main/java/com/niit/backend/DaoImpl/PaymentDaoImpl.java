package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.PaymentDao;
import com.niit.backend.model.Payment;



@Repository("paymentDao")
@EnableTransactionManagement
@Transactional
public class PaymentDaoImpl implements PaymentDao {
	@Autowired
	SessionFactory sessionFactory;
	public PaymentDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional//when ever user says to save the data it will perform that action
	public boolean saveorupdate(Payment payment) {
		sessionFactory.getCurrentSession().saveOrUpdate(payment);
		return true;
	}

	@Transactional
	public boolean delete(Payment payment) {
	  sessionFactory.getCurrentSession().delete(payment);
		return true;
	}

	@Transactional
	public Payment get(String id) {
		String q1="from Payment where p_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Payment>list =(List<Payment>) w.list();//typecasting
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Transactional
	public List<Payment> list() {
		List<Payment> payment=(List<Payment>)
				sessionFactory.getCurrentSession().createCriteria(Payment.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return payment;
	}




}
