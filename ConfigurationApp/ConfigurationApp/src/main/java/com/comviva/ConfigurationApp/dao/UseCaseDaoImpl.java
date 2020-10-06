package com.comviva.ConfigurationApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.ConfigurationApp.model.UseCase;
import com.comviva.ConfigurationApp.model.User;


@Repository
public class UseCaseDaoImpl implements UseCaseDao {
	
	private EntityManager entityManager;

	@Autowired
	public UseCaseDaoImpl(EntityManager theEntityManager ) {
		
		entityManager=theEntityManager;
		
	}

	@Override
	@Transactional
	public String  saveUseCase(UseCase useCase) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		String hql = "from UseCase u where u.userEmail=:userEmail and u.name=:name";
		
		Query query = currentSession.createQuery(hql);
		
		query.setParameter("userEmail", useCase.getUserEmail());
		query.setParameter("name", useCase.getName());
		
		List<UseCase> results = query.getResultList();
		
		if(results.size()==0||results==null) {
			currentSession.saveOrUpdate(useCase);
			return "Use Case Submit Sucessfully";

		}

			return "name already exists. please try again with different name";
		
		
	}

	@Override
	@Transactional

	public List<UseCase> getUseCase(String userEmail) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		String hql="from UseCase uc where uc.userEmail=:userEmail";
		
		
		
		Query query = currentSession.createQuery(hql);
		
		query.setParameter("userEmail", userEmail);
		List<UseCase> results=query.getResultList();
		
		return results;

		
		
	}

	@Override
	@Transactional

	public void deleteUseCase(UseCase useCase) {
		

		Session currentSession= entityManager.unwrap(Session.class);
		
		String hql="delete from UseCase  where id=:id";
		
		
		
		Query query = currentSession.createQuery(hql);
		
		query.setParameter("id", useCase.getId());
		
		query.executeUpdate();

		
		
		
	}
	
	

}
