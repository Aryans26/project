package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.SupplierDao;
import com.niit.backend.model.Supplier;


@Repository("supplierDao")
@EnableTransactionManagement
@Transactional

public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}



	@Transactional
	public boolean saveorupdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}

	@Transactional
	public boolean delete(Supplier supplier) {
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}

	@Transactional
	public Supplier get(String id) {
		String q1="from Supplier where S_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		@SuppressWarnings("unchecked")
		List<Supplier>list=(List<Supplier>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
	
		
		return list.get(0);
	}

	@Transactional
	public List<Supplier> list() {
		List<Supplier> supplier=(List<Supplier>)
				sessionFactory.getCurrentSession().createCriteria(Supplier.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return supplier;
	}
}
