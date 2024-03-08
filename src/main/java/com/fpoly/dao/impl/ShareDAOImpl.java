package com.fpoly.dao.impl;

import java.util.List;

import com.fpoly.dao.AbstractDAO;
import com.fpoly.dao.ShareDAO;
import com.fpoly.entity.Share;

public class ShareDAOImpl extends AbstractDAO<Share> implements ShareDAO {

	@Override
	public List<Share> findByUser(String username) {
		String jpql = "SELECT o FROM Share o WHERE o.user.username = ?0 AND o.video.status = 1"
				+ " ORDER BY o.shareDate DESC";
		return super.findMany(Share.class, jpql, username);
	}

	@Override
	public List<Share> findByUserAndIsLiked(String username) {
		String jpql = "SELECT o FROM Share o WHERE o.user.username = ?0 "
				+ "AND o.video.status = 1"
				+ " ORDER BY o.shareDate DESC";
		return super.findMany(Share.class, jpql, username);
	}

	@Override
	public Share findByUserIdAndVideoId(Integer userId, Integer videoId) {
		String jpql = "SELECT o FROM Share o WHERE o.user.id = ?0 AND o.video.id = ?1 "
				+ "AND o.video.status = 1";
		return super.findOne(Share.class, jpql, userId, videoId);
	}
}
