package com.fpoly.dao;

import java.util.List;

import com.fpoly.entity.Share;

public interface ShareDAO {
	List<Share> findByUser(String username);
	List<Share> findByUserAndIsLiked(String username);
	Share findByUserIdAndVideoId(Integer userId, Integer videoId);
	Share create(Share entity);
	Share update(Share entity);
}
