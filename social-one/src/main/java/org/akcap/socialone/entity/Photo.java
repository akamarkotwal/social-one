package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the photos database table.
 * 
 */
@Entity
@Table(name="photos")
@NamedQuery(name="Photo.findAll", query="SELECT p FROM Photo p")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int photoID;

	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private String imagesDetailes;

	private byte isActive;

	private byte isDelete;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	//bi-directional many-to-one association to Post
	@ManyToOne
	@JoinColumn(name="PostID")
	private Post post;

	public Photo() {
	}

	public int getPhotoID() {
		return this.photoID;
	}

	public void setPhotoID(int photoID) {
		this.photoID = photoID;
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

	public String getImagesDetailes() {
		return this.imagesDetailes;
	}

	public void setImagesDetailes(String imagesDetailes) {
		this.imagesDetailes = imagesDetailes;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}

	public Date getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}