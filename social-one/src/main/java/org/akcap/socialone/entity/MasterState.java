package org.akcap.socialone.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the master_state database table.
 * 
 */
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="master_state")
@NamedQuery(name="MasterState.findAll", query="SELECT m FROM MasterState m")
public class MasterState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to MasterCity
	
	@OneToMany(mappedBy="masterState")
	private List<MasterCity> masterCities;

	//bi-directional many-to-one association to MasterCountry
	
	@ManyToOne()
	@JoinColumn(name="CountryID")
	private MasterCountry masterCountry;
	
	@OneToMany(mappedBy="masterState")
	private List<PersonalAddress> personalAddresses;

	public MasterState() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public List<MasterCity> getMasterCities() {
		return this.masterCities;
	}

	public void setMasterCities(List<MasterCity> masterCities) {
		this.masterCities = masterCities;
	}

	public MasterCity addMasterCity(MasterCity masterCity) {
		getMasterCities().add(masterCity);
		masterCity.setMasterState(this);

		return masterCity;
	}

	public MasterCity removeMasterCity(MasterCity masterCity) {
		getMasterCities().remove(masterCity);
		masterCity.setMasterState(null);

		return masterCity;
	}

	@JsonIgnore
	public MasterCountry getMasterCountry() {
		return this.masterCountry;
	}

	public void setMasterCountry(MasterCountry masterCountry) {
		this.masterCountry = masterCountry;
	}
	public List<PersonalAddress> getPersonalAddresses() {
		return this.personalAddresses;
	}

	public void setPersonalAddresses(List<PersonalAddress> personalAddresses) {
		this.personalAddresses = personalAddresses;
	}

	public PersonalAddress addPersonalAddress(PersonalAddress personalAddress) {
		getPersonalAddresses().add(personalAddress);
		personalAddress.setMasterState(this);

		return personalAddress;
	}

	public PersonalAddress removePersonalAddress(PersonalAddress personalAddress) {
		getPersonalAddresses().remove(personalAddress);
		personalAddress.setMasterState(null);

		return personalAddress;
	}

}