package com.angular.heroes.dao.common;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

/**
 * Common interface spring data repository
 * 
 * @author : HADDAOUI Yassine SOFRECOM
 * @see : <yassine.haddaoui@sofrecom.com>
 * @creation : 04/06/19
 * @version : 1.0
 * 
 * @param <ENTITY>
 * @param <ID>
 */
public class CommonRepositoryImp<ENTITY, ID extends Serializable> extends SimpleJpaRepository<ENTITY, ID> implements ICommonRepository<ENTITY, ID> {

	@Autowired
	EntityManager entityManager;

	/**
	 * Implementation repository
	 * 
	 * @param domainClass
	 * @param entityManager
	 */
	public CommonRepositoryImp(Class<ENTITY> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}
}
