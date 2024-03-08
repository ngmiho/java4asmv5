package com.fpoly.dao;

import java.util.List;

import com.fpoly.entity.Like;


public interface LikeDAO {
	List<Like> findByUser(String username);
	List<Like> findByUserAndIsLiked(String username);
	Like findByUserIdAndVideoId(Integer userId, Integer videoId);
	Like create(Like entity);
	Like update(Like entity);
}
