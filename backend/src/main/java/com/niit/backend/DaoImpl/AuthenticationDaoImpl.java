package com.niit.backend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.Dao.AuthenticationDao;
import com.niit.backend.model.Authentication;

@Repository("authenticationDao")
@EnableTransactionManagement
@Transactional
public class AuthenticationDaoImpl implements AuthenticationDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public AuthenticationDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}

	
	
	public boolean saveorupdate(Authentication authentication) {
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
	}


	public boolean delete(Authentication authentication) {
		sessionFactory.getCurrentSession().delete(authentication);

		return true;
	}


	public Authentication get(String id) {
		String q1="from Authentication where Role_id='"+id+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Authentication> list =(List<Authentication>)w.list();
		if(list==null||list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	

	public List<Authentication> list() {
//		return null;
		List<Authentication> authentication=(List<Authentication>)
				sessionFactory.getCurrentSession().createCriteria(Authentication.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return authentication;
	}


	

	}



