package com.angular.heroes.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.heroes.controllers.dto.HeroDto;
import com.angular.heroes.dao.entities.HeroEntity;
import com.angular.heroes.services.IHeroService;

/**
 * Rest controller hero
 *
 * @author : EL BAZY Zakarya Sofrecom
 * @see : <zakarya.elbazy@sofrecom.com>
 * @creation : 14 nov. 2019
 * @version : 1.0
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/heroes")
public class HeroController {
	
	private static Logger logger = LoggerFactory.getLogger(HeroController.class);
	
	@Autowired(required = false)
	IHeroService heroService;
	
	@GetMapping(value = "/", headers = "Accept=application/json")
	public ResponseEntity<List<HeroDto>> getHeroes(){
		//HeroDto heroDto = new HeroDto();
		List<HeroEntity> listHeroes = heroService.getHeroes();
		logger.info("Returned Heroes : " + listHeroes);
		return new ResponseEntity<List<HeroDto>>(HeroDto.entitiesToDtos(heroService.getHeroes()), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{heroId}", headers = "Accept=application/json")
	public ResponseEntity<HeroDto> getHeroById(@PathVariable("heroId") Long heroId) {
		HeroEntity heroEntity = heroService.FindByHeroId(heroId);
		logger.info("heroEntity : " + heroEntity);
		HeroDto heroDto = null;
		if(heroEntity != null) 
			heroDto = HeroDto.entityToDto(heroEntity);
		
		return new ResponseEntity<HeroDto>(heroDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", headers = "Accept=application/json")
	public ResponseEntity<HeroDto> saveHero(@RequestBody HeroDto heroDto){
		logger.info("Received param : " + heroDto.getName());
		HeroEntity heroEntity = HeroDto.dtoToEntity(heroDto);
		HeroEntity savedHero = heroService.addHero(heroEntity);
		return new ResponseEntity<HeroDto>(HeroDto.entityToDto(savedHero), HttpStatus.OK);
	}
	
	
	
}
