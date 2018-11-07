package com.cities.cities.domain.cities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cities")
public class Cities implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="zipcode")
    private String zipcode;

    @Column(name="population")
    private Long population;

    public Long getId() {
		  return id;
    }
    
	public void setId(Long id) {
		this.id = id;
  }
    
	public String getName() {
		return name;
  }
    
	public void setName(String name) {
		this.name = name;
  }
    
  public String getZipcode() {
		return zipcode;
  }
    
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
  }
    
  public long getPopulation() {
		return population;
  }
    
	public void setPopulation(long population) {
		this.population = population;
	}
}
