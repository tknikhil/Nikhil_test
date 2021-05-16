package com.nkhil.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Transaction;
import javax.transaction.Transactional;

import org.hibernate.Session;

public interface CommonMethods<T> {
	
	public default T findById(Session session,Class<T> entityClass,String id) {
		return session.get(entityClass, id);
	}
	
	public default List<T> findAll(Session session,Class<T> entityClass) {
		final CriteriaQuery<T> query = session.getCriteriaBuilder().createQuery(entityClass);
		final Root<T> root = query.from(entityClass);
			  query.select(root);
		return session.createQuery(query).getResultList();
	}
	
	public default List<T> findAllWithCriteria(Session session,Class<T> entityClass, Predicate[] restrictions ) {	
		return session.createQuery(session.getCriteriaBuilder().createQuery(entityClass).where(restrictions)).getResultList();
	}

	
	@Transactional
	public default T save(Session session, T entity) {
		final Transaction tx = session.beginTransaction();
		session.save(entity);
//		session.saveOrUpdate(entity);
//		session.flush();
		tx.commit();
		return entity;
	}
	
	public default T update(Session session, T entity) {
		session.saveOrUpdate(entity);
		return entity;
	}
	
	public default T delete(Session session, T entity) {
		session.delete(entity);
		return entity;
	}
}
