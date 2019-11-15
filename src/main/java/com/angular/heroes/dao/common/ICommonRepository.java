package com.angular.heroes.dao.common;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

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
@NoRepositoryBean
public interface ICommonRepository<ENTITY, ID extends Serializable> extends JpaRepository<ENTITY, ID>, JpaSpecificationExecutor<ENTITY> {
}
