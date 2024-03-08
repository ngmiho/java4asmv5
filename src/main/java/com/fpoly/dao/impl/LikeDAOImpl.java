package com.fpoly.dao.impl;

import java.util.List;

import com.fpoly.dao.AbstractDAO;
import com.fpoly.dao.LikeDAO;
import com.fpoly.entity.Like;


public class LikeDAOImpl extends AbstractDAO<Like> implements LikeDAO {

	@Override
	public List<Like> findByUser(String username) {
		String jpql = "SELECT o FROM Like o WHERE o.user.username = ?0 AND o.video.status = 1"
				+ " ORDER BY o.likeDate DESC";
		return super.findMany(Like.class, jpql, username);
	}

	@Override
	public List<Like> findByUserAndIsLiked(String username) {
		String jpql = "SELECT o FROM Like o WHERE o.user.username = ?0 "
				+ "AND o.isLike = 1"
				+ " ORDER BY o.likeDate DESC";
		return super.findMany(Like.class, jpql, username);
	}

	@Override
	public Like findByUserIdAndVideoId(Integer userId, Integer videoId) {
		String jpql = "SELECT o FROM Like o WHERE o.user.id = ?0 AND o.video.id = ?1 "
				+ "AND o.video.status = 1";
		return super.findOne(Like.class, jpql, userId, videoId);
	}
}
