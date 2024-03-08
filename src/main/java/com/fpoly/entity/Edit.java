package com.fpoly.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Edits", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"UserId", "VideoId"})
})
public class Edit {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne @JoinColumn(name = "UserId")
	private User user;
	@ManyToOne @JoinColumn(name = "VideoId")
	private Video video;
	@Temporal(TemporalType.DATE)
	private Date createDate = new Date();
	private String editor;
	@Temporal(TemporalType.DATE)
	private Date editDay;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public Date getEditDay() {
		return editDay;
	}
	public void setEditDay(Date editDay) {
		this.editDay = editDay;
	}
	@Override
	public String toString() {
		return "Edit [id=" + id + ", user=" + user + ", video=" + video + ", createDate=" + createDate + ", editor="
				+ editor + ", editDay=" + editDay + "]";
	}
	
}
