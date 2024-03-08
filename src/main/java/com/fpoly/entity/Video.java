package com.fpoly.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@NamedQueries({
	@NamedQuery(name = "Video.findAll",
			query = "SELECT o FROM Video o")
})

@Entity
@Table(name = "Videos")
public class Video {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String detail;
	private Boolean status;
	private String note;
	private String href;
	private Integer views;
	@OneToMany(mappedBy = "video")
	List<Like> likes;
	@OneToMany(mappedBy = "video")
	List<Share> shares;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
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
	
}
