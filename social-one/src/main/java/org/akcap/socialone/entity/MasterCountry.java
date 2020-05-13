package org.akcap.socialone.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the master_country database table.
 * 
 */
@Entity
@Table(name="master_country")
@NamedQuery(name="MasterCountry.findAll", query="SELECT m FROM MasterCountry m")
public class MasterCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short id;

	private String currency;

	private String isoName;

	private String name;

	//bi-directional many-to-one association to MasterState
	@OneToMany(mappedBy="masterCountry")
	private List<MasterState> masterStates;

	public MasterCountry() {
	}

	public short getId() {
		return this.id;
	}

	public void setId(short id) {
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

}