package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the master_city database table.
 * 
 */
@Entity
@Table(name="master_city")
@NamedQuery(name="MasterCity.findAll", query="SELECT m FROM MasterCity m")
public class MasterCity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short id;

	private String name;

	//bi-directional many-to-one association to MasterState
	@ManyToOne
	@JoinColumn(name="StateId")
	private MasterState masterState;

	public MasterCity() {
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

	public MasterState getMasterState() {
		return this.masterState;
	}

	public void setMasterState(MasterState masterState) {
		this.masterState = masterState;
	}

}