package com.angular.heroes.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.angular.heroes.dao.common.ICommonRepository;
import com.angular.heroes.dao.entities.HeroEntity;

/**
 * Spring data repository "CandidatDemande"
 * 
 * @author : EL BAZY Zakarya SOFRECOM
 * @see : <zakarya.elbazy@sofrecom.com>
 * @creation : 14/11/19
 * @version : 1.0
 */

@Repository
public interface IHeroRepository extends ICommonRepository<HeroEntity, Long>{
	
	@Query("SELECT hr FROM HeroEntity hr WHERE id = ?1")
	HeroEntity FindByHeroId(@Param("heroId") Long heroId);
	
	@Query("SELECT hr FROM HeroEntity hr")
	List<HeroEntity> ListAllFromHeroEntity();
	
	@Query(value = "INSERT INTO hero (hero_name) values (:heroName)", nativeQuery = true)
	void InsertHero(@Param("heroName") String heroName);
	
	@SuppressWarnings("unchecked")
	HeroEntity save(HeroEntity heroEntity);

}
