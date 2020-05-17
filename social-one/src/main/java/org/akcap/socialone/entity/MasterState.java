package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;


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
	private short id;

	private String name;

	//bi-directional many-to-one association to MasterCity
	@OneToMany(mappedBy="masterState",fetch = FetchType.LAZY )
	private List<MasterCity> masterCities;

	//bi-directional many-to-one association to MasterCountry
	@ManyToOne
	@JoinColumn(name="CountryID")
	private MasterCountry masterCountry;

	public MasterState() {
	}

	public short getId() {
		return this.id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public MasterCountry getMasterCountry() {
		return this.masterCountry;
	}

	public void setMasterCountry(MasterCountry masterCountry) {
		this.masterCountry = masterCountry;
	}

}