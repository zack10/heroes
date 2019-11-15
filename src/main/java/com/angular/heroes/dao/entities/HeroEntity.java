package com.angular.heroes.dao.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.angular.heroes.dao.entities.common.AbstractCommonEntity;

/**
 * Persistent class for entity stored in table "hero"
 * 
 * @author : EL BAZY Zakarya
 * @see : <zelbazy@gmail.com>
 * @creation : 14/11/19
 * @version : 1.0
 */

@Entity
@Table(name = "hero")
public class HeroEntity extends AbstractCommonEntity<Long> implements Cloneable {
	
	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(HeroEntity.class);
	
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "hero_name", length = 255)
	private String heroName;
	
	public HeroEntity() {
		super();
	}
	
	public HeroEntity(long id, String heroName) {
		super();
		this.id = id;
		this.heroName = heroName;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "HeroEntity[id=" + id + "heroName=" + heroName + "]";
	}
	
	@Override
	public HeroEntity clone() {
		HeroEntity faqcategoriesentity = null;
		try {
			faqcategoriesentity = (HeroEntity) super.clone();
		} catch (CloneNotSupportedException cnse) {
			logger.error("Error occured");
		}
		return faqcategoriesentity;
	}

	/**
	 * @return the id
	 */
	@Override
	public Long getId() {
		return id;
	}

}
