package com.comviva.ConfigurationApp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.ConfigurationApp.model.UseCase;

@Repository
public class ExportImportImplDao implements ExportImportDao {
	
	private EntityManager entityManager;

	@Autowired
	public ExportImportImplDao(EntityManager theEntityManager ) {
		
		entityManager=theEntityManager;
		
	}


	
}
