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
@Table(name = "Shares", uniqueConstraints = {
		@UniqueConstraint(columnNames =  {"UserId", "VideoId"})
})
public class Share {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne @JoinColumn(name = "UserId")
	private User user;
	@ManyToOne @JoinColumn(name = "VideoId")
	private Video video;
	private String emails;
	@Temporal(TemporalType.DATE)
	private Date shareDate = new Date();
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
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}
	public Date getShareDate() {
		return shareDate;
	}
	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}
	@Override
	public String toString() {
		return "Share [id=" + id + ", user=" + user + ", video=" + video + ", emails=" + emails + ", shareDate="
				+ shareDate + "]";
	}
	
}
