package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user_infomation database table.
 * 
 */
@Entity
@Table(name="user_infomation")
@NamedQuery(name="UserInfomation.findAll", query="SELECT u FROM UserInfomation u")
public class UserInfomation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private Integer createdBy;

	
	private Date createdDate;

	
	private Date dob;

	private String fname;
	
	private String email;

	private byte isActive;

	private byte isDelete;

	private String lname;

	private String password;

	private Integer updatedBy;

	
	private Date updatedDate;

	private String userName;

	//bi-directional many-to-one association to AddFriend
	@OneToMany(mappedBy="userInfomation1")
	private List<AddFriend> addFriends1;

	//bi-directional many-to-one association to AddFriend
	@OneToMany(mappedBy="userInfomation2")
	private List<AddFriend> addFriends2;

	//bi-directional many-to-one association to CollegeDetail
	@OneToMany(mappedBy="userInfomation")
	private List<CollegeDetail> collegeDetails;

	//bi-directional many-to-one association to CommentReply
	@OneToMany(mappedBy="userInfomation")
	private List<CommentReply> commentReplies;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="userInfomation")
	private List<Comment> comments;

	//bi-directional many-to-one association to CommentsLike
	@OneToMany(mappedBy="userInfomation")
	private List<CommentsLike> commentsLikes;

	//bi-directional many-to-one association to Friendship
	@OneToMany(mappedBy="userInfomation1")
	private List<Friendship> friendships1;

	//bi-directional many-to-one association to Friendship
	@OneToMany(mappedBy="userInfomation2")
	private List<Friendship> friendships2;

	//bi-directional many-to-one association to HighschoolDetail
	@OneToMany(mappedBy="userInfomation")
	private List<HighschoolDetail> highschoolDetails;

	//bi-directional many-to-one association to PersonalAddress
	@OneToMany(mappedBy="userInfomation")
	private List<PersonalAddress> personalAddresses;

	//bi-directional many-to-one association to PersonalDetail
	@OneToMany(mappedBy="userInfomation")
	private List<PersonalDetail> personalDetails;

	//bi-directional many-to-one association to PostLike
	@OneToMany(mappedBy="userInfomation")
	private List<PostLike> postLikes;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="userInfomation")
	private List<Post> posts;

	//bi-directional many-to-one association to ProfessionalDetail
	@OneToMany(mappedBy="userInfomation")
	private List<ProfessionalDetail> professionalDetails;

	//bi-directional many-to-one association to Share
	@OneToMany(mappedBy="userInfomation")
	private List<Share> shares;

	//bi-directional many-to-one association to MasterGender
	
	@ManyToOne
	@JoinColumn(name="Gender")
	private MasterGender masterGender;

	//bi-directional many-to-one association to UserSociallink
	@OneToMany(mappedBy="userInfomation")
	private List<UserSociallink> userSociallinks;

	public UserInfomation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
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

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<AddFriend> getAddFriends1() {
		return this.addFriends1;
	}

	public void setAddFriends1(List<AddFriend> addFriends1) {
		this.addFriends1 = addFriends1;
	}

	public AddFriend addAddFriends1(AddFriend addFriends1) {
		getAddFriends1().add(addFriends1);
		addFriends1.setUserInfomation1(this);

		return addFriends1;
	}

	public AddFriend removeAddFriends1(AddFriend addFriends1) {
		getAddFriends1().remove(addFriends1);
		addFriends1.setUserInfomation1(null);

		return addFriends1;
	}

	public List<AddFriend> getAddFriends2() {
		return this.addFriends2;
	}

	public void setAddFriends2(List<AddFriend> addFriends2) {
		this.addFriends2 = addFriends2;
	}

	public AddFriend addAddFriends2(AddFriend addFriends2) {
		getAddFriends2().add(addFriends2);
		addFriends2.setUserInfomation2(this);

		return addFriends2;
	}

	public AddFriend removeAddFriends2(AddFriend addFriends2) {
		getAddFriends2().remove(addFriends2);
		addFriends2.setUserInfomation2(null);

		return addFriends2;
	}

	public List<CollegeDetail> getCollegeDetails() {
		return this.collegeDetails;
	}

	public void setCollegeDetails(List<CollegeDetail> collegeDetails) {
		this.collegeDetails = collegeDetails;
	}

	public CollegeDetail addCollegeDetail(CollegeDetail collegeDetail) {
		getCollegeDetails().add(collegeDetail);
		collegeDetail.setUserInfomation(this);

		return collegeDetail;
	}

	public CollegeDetail removeCollegeDetail(CollegeDetail collegeDetail) {
		getCollegeDetails().remove(collegeDetail);
		collegeDetail.setUserInfomation(null);

		return collegeDetail;
	}

	public List<CommentReply> getCommentReplies() {
		return this.commentReplies;
	}

	public void setCommentReplies(List<CommentReply> commentReplies) {
		this.commentReplies = commentReplies;
	}

	public CommentReply addCommentReply(CommentReply commentReply) {
		getCommentReplies().add(commentReply);
		commentReply.setUserInfomation(this);

		return commentReply;
	}

	public CommentReply removeCommentReply(CommentReply commentReply) {
		getCommentReplies().remove(commentReply);
		commentReply.setUserInfomation(null);

		return commentReply;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUserInfomation(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUserInfomation(null);

		return comment;
	}

	public List<CommentsLike> getCommentsLikes() {
		return this.commentsLikes;
	}

	public void setCommentsLikes(List<CommentsLike> commentsLikes) {
		this.commentsLikes = commentsLikes;
	}

	public CommentsLike addCommentsLike(CommentsLike commentsLike) {
		getCommentsLikes().add(commentsLike);
		commentsLike.setUserInfomation(this);

		return commentsLike;
	}

	public CommentsLike removeCommentsLike(CommentsLike commentsLike) {
		getCommentsLikes().remove(commentsLike);
		commentsLike.setUserInfomation(null);

		return commentsLike;
	}

	public List<Friendship> getFriendships1() {
		return this.friendships1;
	}

	public void setFriendships1(List<Friendship> friendships1) {
		this.friendships1 = friendships1;
	}

	public Friendship addFriendships1(Friendship friendships1) {
		getFriendships1().add(friendships1);
		friendships1.setUserInfomation1(this);

		return friendships1;
	}

	public Friendship removeFriendships1(Friendship friendships1) {
		getFriendships1().remove(friendships1);
		friendships1.setUserInfomation1(null);

		return friendships1;
	}

	public List<Friendship> getFriendships2() {
		return this.friendships2;
	}

	public void setFriendships2(List<Friendship> friendships2) {
		this.friendships2 = friendships2;
	}

	public Friendship addFriendships2(Friendship friendships2) {
		getFriendships2().add(friendships2);
		friendships2.setUserInfomation2(this);

		return friendships2;
	}

	public Friendship removeFriendships2(Friendship friendships2) {
		getFriendships2().remove(friendships2);
		friendships2.setUserInfomation2(null);

		return friendships2;
	}

	public List<HighschoolDetail> getHighschoolDetails() {
		return this.highschoolDetails;
	}

	public void setHighschoolDetails(List<HighschoolDetail> highschoolDetails) {
		this.highschoolDetails = highschoolDetails;
	}

	public HighschoolDetail addHighschoolDetail(HighschoolDetail highschoolDetail) {
		getHighschoolDetails().add(highschoolDetail);
		highschoolDetail.setUserInfomation(this);

		return highschoolDetail;
	}

	public HighschoolDetail removeHighschoolDetail(HighschoolDetail highschoolDetail) {
		getHighschoolDetails().remove(highschoolDetail);
		highschoolDetail.setUserInfomation(null);

		return highschoolDetail;
	}

	public List<PersonalAddress> getPersonalAddresses() {
		return this.personalAddresses;
	}

	public void setPersonalAddresses(List<PersonalAddress> personalAddresses) {
		this.personalAddresses = personalAddresses;
	}

	public PersonalAddress addPersonalAddress(PersonalAddress personalAddress) {
		getPersonalAddresses().add(personalAddress);
		personalAddress.setUserInfomation(this);

		return personalAddress;
	}

	public PersonalAddress removePersonalAddress(PersonalAddress personalAddress) {
		getPersonalAddresses().remove(personalAddress);
		personalAddress.setUserInfomation(null);

		return personalAddress;
	}

	public List<PersonalDetail> getPersonalDetails() {
		return this.personalDetails;
	}

	public void setPersonalDetails(List<PersonalDetail> personalDetails) {
		this.personalDetails = personalDetails;
	}

	public PersonalDetail addPersonalDetail(PersonalDetail personalDetail) {
		getPersonalDetails().add(personalDetail);
		personalDetail.setUserInfomation(this);

		return personalDetail;
	}

	public PersonalDetail removePersonalDetail(PersonalDetail personalDetail) {
		getPersonalDetails().remove(personalDetail);
		personalDetail.setUserInfomation(null);

		return personalDetail;
	}

	public List<PostLike> getPostLikes() {
		return this.postLikes;
	}

	public void setPostLikes(List<PostLike> postLikes) {
		this.postLikes = postLikes;
	}

	public PostLike addPostLike(PostLike postLike) {
		getPostLikes().add(postLike);
		postLike.setUserInfomation(this);

		return postLike;
	}

	public PostLike removePostLike(PostLike postLike) {
		getPostLikes().remove(postLike);
		postLike.setUserInfomation(null);

		return postLike;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setUserInfomation(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setUserInfomation(null);

		return post;
	}

	public List<ProfessionalDetail> getProfessionalDetails() {
		return this.professionalDetails;
	}

	public void setProfessionalDetails(List<ProfessionalDetail> professionalDetails) {
		this.professionalDetails = professionalDetails;
	}

	public ProfessionalDetail addProfessionalDetail(ProfessionalDetail professionalDetail) {
		getProfessionalDetails().add(professionalDetail);
		professionalDetail.setUserInfomation(this);

		return professionalDetail;
	}

	public ProfessionalDetail removeProfessionalDetail(ProfessionalDetail professionalDetail) {
		getProfessionalDetails().remove(professionalDetail);
		professionalDetail.setUserInfomation(null);

		return professionalDetail;
	}

	public List<Share> getShares() {
		return this.shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Share addShare(Share share) {
		getShares().add(share);
		share.setUserInfomation(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setUserInfomation(null);

		return share;
	}

	public MasterGender getMasterGender() {
		return this.masterGender;
	}

	public void setMasterGender(MasterGender masterGender) {
		this.masterGender = masterGender;
	}

	public List<UserSociallink> getUserSociallinks() {
		return this.userSociallinks;
	}

	public void setUserSociallinks(List<UserSociallink> userSociallinks) {
		this.userSociallinks = userSociallinks;
	}

	public UserSociallink addUserSociallink(UserSociallink userSociallink) {
		getUserSociallinks().add(userSociallink);
		userSociallink.setUserInfomation(this);

		return userSociallink;
	}

	public UserSociallink removeUserSociallink(UserSociallink userSociallink) {
		getUserSociallinks().remove(userSociallink);
		userSociallink.setUserInfomation(null);

		return userSociallink;
	}

}