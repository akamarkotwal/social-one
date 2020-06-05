package org.akcap.socialone.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;


import java.util.Date;

/**
 * The persistent class for the professional_details database table.
 * 
 */
@Entity
@Table(name = "professional_details")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name = "ProfessionalDetail.findAll", query = "SELECT p FROM ProfessionalDetail p")
public class ProfessionalDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// bi-directional many-to-one association to MasterCity
	@ManyToOne
	@JoinColumn(name = "`City/Town`")
	private MasterCity masterCity;

	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	private String organization;

	private String position;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	private int updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	// bi-directional many-to-one association to UserInfomation
	@ManyToOne
	@JoinColumn(name = "UserId")
	private UserInfomation userInfomation;

	public ProfessionalDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public MasterCity getMasterCity() {
		return masterCity;
	}

	public void setMasterCity(MasterCity masterCity) {
		this.masterCity = masterCity;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOrganization() {
		return this.organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public UserInfomation getUserInfomation() {
		return this.userInfomation;
	}

	public void setUserInfomation(UserInfomation userInfomation) {
		this.userInfomation = userInfomation;
	}

	@Override
	public String toString() {
		return "ProfessionalDetail [id=" + id + ", masterCity=" + masterCity + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", description=" + description + ", endDate=" + endDate
				+ ", organization=" + organization + ", position=" + position + ", startDate=" + startDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", userInfomation=" + userInfomation
				+ "]";
	}

	
}