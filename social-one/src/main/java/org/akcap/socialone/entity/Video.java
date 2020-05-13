package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the videos database table.
 * 
 */
@Entity
@Table(name="videos")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int videoID;

	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private byte isActive;

	private byte isDelete;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	private String videoDetailes;

	//bi-directional many-to-one association to Post
	@ManyToOne
	@JoinColumn(name="PostID")
	private Post post;

	public Video() {
	}

	public int getVideoID() {
		return this.videoID;
	}

	public void setVideoID(int videoID) {
		this.videoID = videoID;
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

	public String getVideoDetailes() {
		return this.videoDetailes;
	}

	public void setVideoDetailes(String videoDetailes) {
		this.videoDetailes = videoDetailes;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}