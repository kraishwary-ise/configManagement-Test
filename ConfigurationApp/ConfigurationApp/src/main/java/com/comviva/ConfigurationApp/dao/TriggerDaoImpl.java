package com.comviva.ConfigurationApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.ConfigurationApp.model.Trigger;
import com.comviva.ConfigurationApp.model.TriggerLib;
import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.response.NameEmail;

@Repository
public class TriggerDaoImpl implements TriggerDao {
	
	private EntityManager entityManager;

	@Autowired
	public TriggerDaoImpl(EntityManager theEntityManager ) {
		
		entityManager=theEntityManager;
		
	}

	@Override
	@Transactional
	public List<TriggerLib> getTrigger() {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		String hql = "from TriggerLib tl";
		
		Query query = currentSession.createQuery(hql);
		
		List<TriggerLib> results = query.getResultList();
		
		return results;

		
		
		
		
		
	}
	
	
	

	@Override
	public void saveTrigger(NameEmail nameEmail[]) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		String hql = "from UseCase u where u.userEmail=:userEmail and u.name=:name";
		
		Query query = currentSession.createQuery(hql);
		

		query.setParameter("userEmail", nameEmail[0].getEmail());
		query.setParameter("name", nameEmail[0].getName());
		
		
		List<UseCase> results = query.getResultList();
		UseCase result=results.get(0);
		
		int useId=result.getId();
		
		for(int i=0;i<nameEmail.length;i++) {
			
		System.out.println("inside for loop");
		Trigger trigger=new Trigger(useId,nameEmail[i].getTriggerName());
		
		currentSession.saveOrUpdate(trigger);
		
	}
		
		
		
		
	}
	
	
	

}
