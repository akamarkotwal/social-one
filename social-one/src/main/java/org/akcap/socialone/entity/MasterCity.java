package org.akcap.socialone.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * The persistent class for the master_city database table.
 * 
 */
@Entity
@Table(name="master_city")
@Cacheable
@NamedQuery(name="MasterCity.findAll", query="SELECT m FROM MasterCity m")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MasterCity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to MasterState
	@ManyToOne
	@JoinColumn(name="StateId")
	private MasterState masterState;
	
	@OneToMany(mappedBy="masterCity")
	private List<PersonalAddress> personalAddresses;

	public MasterCity() {
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
	public MasterState getMasterState() {
		return this.masterState;
	}

	public void setMasterState(MasterState masterState) {
		this.masterState = masterState;
	}
	public List<PersonalAddress> getPersonalAddresses() {
		return this.personalAddresses;
	}

	public void setPersonalAddresses(List<PersonalAddress> personalAddresses) {
		this.personalAddresses = personalAddresses;
	}

	public PersonalAddress addPersonalAddress(PersonalAddress personalAddress) {
		getPersonalAddresses().add(personalAddress);
		personalAddress.setMasterCity(this);

		return personalAddress;
	}

	public PersonalAddress removePersonalAddress(PersonalAddress personalAddress) {
		getPersonalAddresses().remove(personalAddress);
		personalAddress.setMasterCity(null);

		return personalAddress;
	}

}