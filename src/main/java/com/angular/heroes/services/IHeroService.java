package com.angular.heroes.services;

import java.util.List;
import java.util.Optional;

import com.angular.heroes.dao.entities.HeroEntity;

/**
 *@interface Hero service
 *
 * @author : EL BAZY Zakarya Sofrecom
 * @see : <zakarya.elbazy@sofrecom.com>
 * @creation : 14 nov. 2019
 * @version : 1.0
 */
public interface IHeroService {
	
	/**
	 * a completer ...
	 * 
	 * @param void
	 * @return Optional<HeroEntity>
	 * @throws Exception
	 */
	List<HeroEntity> getHeroes();
	
	HeroEntity FindByHeroId(Long heroId);
	
	HeroEntity addHero(HeroEntity heroEntity);
	
}
