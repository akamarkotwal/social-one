package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name="comments")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String commentContent;

	@Temporal(TemporalType.TIMESTAMP)
	private Date commentsDate;

	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private byte isActive;

	private byte isDelete;

	private int updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	//bi-directional many-to-one association to CommentReply
	@OneToMany(mappedBy="comment")
	private List<CommentReply> commentReplies;

	//bi-directional many-to-one association to Post
	@ManyToOne
	@JoinColumn(name="PostID")
	private Post post;

	//bi-directional many-to-one association to UserInfomation
	@ManyToOne
	@JoinColumn(name="UserId")
	private UserInfomation userInfomation;

	//bi-directional many-to-one association to CommentsLike
	@OneToMany(mappedBy="comment")
	private List<CommentsLike> commentsLikes;

	public Comment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentsDate() {
		return this.commentsDate;
	}

	public void setCommentsDate(Date commentsDate) {
		this.commentsDate = commentsDate;
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

	public List<CommentReply> getCommentReplies() {
		return this.commentReplies;
	}

	public void setCommentReplies(List<CommentReply> commentReplies) {
		this.commentReplies = commentReplies;
	}

	public CommentReply addCommentReply(CommentReply commentReply) {
		getCommentReplies().add(commentReply);
		commentReply.setComment(this);

		return commentReply;
	}

	public CommentReply removeCommentReply(CommentReply commentReply) {
		getCommentReplies().remove(commentReply);
		commentReply.setComment(null);

		return commentReply;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public UserInfomation getUserInfomation() {
		return this.userInfomation;
	}

	public void setUserInfomation(UserInfomation userInfomation) {
		this.userInfomation = userInfomation;
	}

	public List<CommentsLike> getCommentsLikes() {
		return this.commentsLikes;
	}

	public void setCommentsLikes(List<CommentsLike> commentsLikes) {
		this.commentsLikes = commentsLikes;
	}

	public CommentsLike addCommentsLike(CommentsLike commentsLike) {
		getCommentsLikes().add(commentsLike);
		commentsLike.setComment(this);

		return commentsLike;
	}

	public CommentsLike removeCommentsLike(CommentsLike commentsLike) {
		getCommentsLikes().remove(commentsLike);
		commentsLike.setComment(null);

		return commentsLike;
	}

}