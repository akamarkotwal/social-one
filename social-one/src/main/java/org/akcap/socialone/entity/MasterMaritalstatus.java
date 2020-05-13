package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the master_maritalstatus database table.
 * 
 */
@Entity
@Table(name="master_maritalstatus")
@NamedQuery(name="MasterMaritalstatus.findAll", query="SELECT m FROM MasterMaritalstatus m")
public class MasterMaritalstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	public MasterMaritalstatus() {
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

}