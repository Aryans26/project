package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.CategoryDao;
import com.niit.backend.model.Category;

@SuppressWarnings("unchecked")
@Repository("categoryDao")
@EnableTransactionManagement
@Transactional

public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public boolean saveOrUpdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}


	public boolean delete(Category cat) {
//		Category cat = new Category();
//		cat.setC_id(id);
		sessionFactory.getCurrentSession().delete(cat);
		
		return true;
	}

	
	@SuppressWarnings("deprecation")
	public Category getCategory(String id) {
		String q1 = "from Category where C_id='"+id+"'";
	 Query w= sessionFactory.getCurrentSession().createQuery(q1);
	
		List<Category> list = (List<Category>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		return list.get(0);
	}


	@Transactional
	public Category getCategoryp(String id){
		String q1 = "from Product where C_id='" + id + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Category> list = (List<Category>) w.list();
		if (list == null || list.isEmpty()) 
		{
			return null;
		}
		   return list.get(0);
	   }
	
	public List<Category> list() {
		List<Category> category=(List<Category>)
				sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return category;
	}

}
