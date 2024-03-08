package com.fpoly.service;

import java.util.List;

import com.fpoly.entity.Like;
import com.fpoly.entity.User;
import com.fpoly.entity.Video;

public interface LikeService {
	List<Like> findByUser(String username);
	List<Like> findByUserAndIsLiked(String username);
	Like findByUserIdAndVideoId(Integer userId, Integer videoId);
	Like create(User user, Video video);
	Like delete(Like entity);
	boolean updateLikeOrUnlike(User user, String videoHref);
}
