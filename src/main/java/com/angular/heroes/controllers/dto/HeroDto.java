package com.angular.heroes.controllers.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.CollectionUtils;

import com.angular.heroes.dao.entities.HeroEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * HeroDto DTO (Data Transfer Object)
 *
 * @author : EL BAZY Zakarya Sofrecom
 * @see : <zakarya.elbazy@sofrecom.com>
 * @creation : 14 nov. 2019
 * @version : 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeroDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private long id;
	
	@Size(max = 255)
	private String name;

	public HeroDto() {
		super();
	}

	public HeroDto(@NotNull long id, @Size(max = 255) String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String heroName) {
		this.name = heroName;
	}
	
	public static HeroDto entityToDto(HeroEntity heroEntity) {
		HeroDto heroDto = new HeroDto();
		if(heroEntity != null) {
			heroDto.setId(heroEntity.getId());
			heroDto.setName(heroEntity.getHeroName());
		}
		return heroDto;
	}
	
	public static List<HeroDto> entitiesToDtos(List<HeroEntity> listEntities) {
		List<HeroDto> listHeroDto = new ArrayList<>();
		
		if(!CollectionUtils.isEmpty(listEntities)) {
			for(HeroEntity entity : listEntities) {
				listHeroDto.add(entityToDto(entity));
			}
		}
		return listHeroDto;
	}
	
	public static HeroEntity dtoToEntity(HeroDto dto) {
		HeroEntity heroEntity = new HeroEntity();
		if(dto != null) {
			heroEntity.setId(dto.getId());
			heroEntity.setHeroName(dto.getName());
		}
		return heroEntity;
	}
	
	public static List<HeroEntity> dtosToEntities(List<HeroDto> listDtos) {
		 List<HeroEntity> listHeroEntity = new ArrayList<>();
		 if(!CollectionUtils.isEmpty(listDtos)) {
			 for(HeroDto dto : listDtos) {
				 listHeroEntity.add(dtoToEntity(dto));
			 }
		 }
		 return listHeroEntity;
	}
	
	
}
