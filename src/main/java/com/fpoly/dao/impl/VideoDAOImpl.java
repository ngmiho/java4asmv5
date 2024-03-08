package com.fpoly.dao.impl;

import java.util.List;

import com.fpoly.dao.AbstractDAO;
import com.fpoly.dao.VideoDAO;
import com.fpoly.entity.Video;

public class VideoDAOImpl extends AbstractDAO<Video> implements VideoDAO {

	@Override
	public Video findById(Integer id) {
		return super.findById(Video.class, id);
	}

	@Override
	public Video findByHref(String href) {
		String jpql = "SELECT o FROM Video o WHERE o.href = ?0";
		return super.findOne(Video.class, jpql, href);
	}

	@Override
	public List<Video> findAll() {
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		return super.findAll(Video.class, true, pageNumber, pageSize);
	}
}
