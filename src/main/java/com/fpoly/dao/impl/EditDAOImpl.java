package com.fpoly.dao.impl;

import java.util.List;

import com.fpoly.dao.AbstractDAO;
import com.fpoly.dao.EditDAO;
import com.fpoly.entity.Edit;

public class EditDAOImpl extends AbstractDAO<Edit> implements EditDAO {

	@Override
	public List<Edit> findByUser(String username) {
		String jpql = "SELECT o FROM Edit o WHERE o.user.username = ?0 AND o.video.status = 1"
				+ " ORDER BY o.createDate DESC";
		return super.findMany(Edit.class, jpql, username);
	}

	@Override
	public List<Edit> findByUserAndIsLiked(String username) {
		String jpql = "SELECT o FROM Edit o WHERE o.user.username = ?0 "
				+ "AND o.video.status = 1"
				+ " ORDER BY o.createDate DESC";
		return super.findMany(Edit.class, jpql, username);
	}

	@Override
	public Edit findByUserIdAndVideoId(Integer userId, Integer videoId) {
		String jpql = "SELECT o FROM Edit o WHERE o.user.id = ?0 AND o.video.id = ?1 "
				+ "AND o.video.status = 1";
		return super.findOne(Edit.class, jpql, userId, videoId);
	}
}
