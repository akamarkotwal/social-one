package org.akcap.socialone.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;



import java.util.List;


/**
 * The persistent class for the master_country database table.
 * 
 */
@Entity
@Table(name="master_country")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name="MasterCountry.findAll", query="SELECT m FROM MasterCountry m")
public class MasterCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String currency;

	private String isoName;

	private String name;

	//bi-directional many-to-one association to MasterState
	@OneToMany(mappedBy="masterCountry")
	private List<MasterState> masterStates;
	
	@OneToMany(mappedBy="masterCountry")
	private List<PersonalAddress> personalAddresses;

	public MasterCountry() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getIsoName() {
		return this.isoName;
	}

	public void setIsoName(String isoName) {
		this.isoName = isoName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public List<MasterState> getMasterStates() {
		return this.masterStates;
	}

	public void setMasterStates(List<MasterState> masterStates) {
		this.masterStates = masterStates;
	}

	public MasterState addMasterState(MasterState masterState) {
		getMasterStates().add(masterState);
		masterState.setMasterCountry(this);

		return masterState;
	}

	public MasterState removeMasterState(MasterState masterState) {
		getMasterStates().remove(masterState);
		masterState.setMasterCountry(null);

		return masterState;
	}
	public List<PersonalAddress> getPersonalAddresses() {
		return this.personalAddresses;
	}

	public void setPersonalAddresses(List<PersonalAddress> personalAddresses) {
		this.personalAddresses = personalAddresses;
	}

	public PersonalAddress addPersonalAddress(PersonalAddress personalAddress) {
		getPersonalAddresses().add(personalAddress);
		personalAddress.setMasterCountry(this);

		return personalAddress;
	}

	public PersonalAddress removePersonalAddress(PersonalAddress personalAddress) {
		getPersonalAddresses().remove(personalAddress);
		personalAddress.setMasterCountry(null);

		return personalAddress;
	}

}