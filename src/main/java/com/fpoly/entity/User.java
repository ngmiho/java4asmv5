package com.fpoly.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fpoly.constant.NamedStored;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = NamedStored.FIND_USERS_LIKED_VIDEO_BY_VIDEO_HREF,
			procedureName = "sp_selectUsersLikedVideoByVideoHred",
			parameters = @StoredProcedureParameter(name = "videoHref", type = String.class))
})

@Entity
@Table(name = "Users")
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Integer gender;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	private Boolean role;
	private Boolean status;
	@OneToMany(mappedBy = "user")
	List<Like> likes;
	@OneToMany(mappedBy = "user")
	List<Share> shares;
	@OneToMany(mappedBy = "user")
	List<Edit> edits;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Boolean getRole() {
		return role;
	}
	public void setRole(Boolean role) {
		this.role = role;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public List<Like> getLikes() {
		return likes;
	}
	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}
	public List<Share> getShares() {
		return shares;
	}
	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	public List<Edit> getEdits() {
		return edits;
	}
	public void setEdits(List<Edit> edits) {
		this.edits = edits;
	}
}
