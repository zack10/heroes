package com.angular.heroes.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.heroes.dao.IHeroRepository;
import com.angular.heroes.dao.entities.HeroEntity;
import com.angular.heroes.services.IHeroService;

/**
 *@class Hero service
 *
 * @author : EL BAZY Zakarya Sofrecom
 * @see : <zakarya.elbazy@sofrecom.com>
 * @creation : 14 nov. 2019
 * @version : 1.0
 */
@Transactional
@Service
public class HeroService implements IHeroService {
		
	private static Logger logger = LoggerFactory.getLogger(HeroService.class);
	
	@Autowired
	IHeroRepository heroRepository;
	
	@Override
	public List<HeroEntity> getHeroes() {
		return heroRepository.ListAllFromHeroEntity();
	}

	@Override
	public HeroEntity FindByHeroId(Long heroId) {
		return heroRepository.FindByHeroId(heroId);
	}

	@Override
	public HeroEntity addHero(HeroEntity heroEntity) {
		heroRepository.InsertHero(heroEntity.getHeroName());
		return null;
	}

	@Override
	public HeroEntity insertHero(HeroEntity heroEntity) {
		return heroRepository.save(heroEntity);
	}

	@Override
	public void deleteHero(Long heroId) {
		heroRepository.deleteHero(heroId);
	}

	@Override
	public List<HeroEntity> searchHeroes(String heroName) {
		return heroRepository.searchHeroes(heroName);
	}

}
