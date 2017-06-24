package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.ProductDao;
import com.niit.backend.model.Product;

@Repository("productDao")
@EnableTransactionManagement
@SuppressWarnings("unchecked")
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;
	public ProductDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveorupdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}

	@Transactional
	public boolean delete(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	@Transactional
	public Product get(String id) {
		String q1="from Product where P_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Product>list=(List<Product>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}

	@Transactional
	public List<Product> getproductC(String id) {
		String q1 = "from Product where C_id='"+id+"'";
		Query w = sessionFactory.openSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
		
	    }
	@Transactional
	public List<Product> getproductPro(String Name) {
		String q1 = "from Product where P_name='"+Name+"'";
		Query w = sessionFactory.openSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
		
	    }


	@Transactional
	public List<Product> getproductPrice() {
		String q1 = "from Product where P_c between 100 and 500";
		Query w = sessionFactory.openSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
		
	    }
	@Transactional
	public List<Product> getproductPrice2() {
		String q1 = "from Product where P_c between 500 and 1000";
		Query w = sessionFactory.openSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
		
	    }
	@Transactional
	public List<Product> getproductPrice3() {
		String q1 = "from Product where P_c between 1000 and 2000";
		Query w = sessionFactory.openSession().createQuery(q1);
		List<Product> list = (List<Product>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list;
		
	    }

	@Transactional
	public List<Product> list() {
		List<Product> product=(List<Product>)
				sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return product;
	}

	
}
