package com.fpoly.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.fpoly.dao.LikeDAO;
import com.fpoly.dao.impl.LikeDAOImpl;
import com.fpoly.entity.Like;
import com.fpoly.entity.User;
import com.fpoly.entity.Video;
import com.fpoly.service.LikeService;
import com.fpoly.service.VideoService;

public class LikeServiceImpl implements LikeService {
	
	private LikeDAO dao;
	private VideoService videoService = new VideoServiceImpl();
	
	public LikeServiceImpl() {
		dao = new LikeDAOImpl();
	}

	@Override
	public List<Like> findByUser(String username) {
		return dao.findByUser(username);
	}

	@Override
	public List<Like> findByUserAndIsLiked(String username) {
		return dao.findByUserAndIsLiked(username);
	}
	
	@Override
	public Like findByUserIdAndVideoId(Integer userId, Integer videoId) {
		return dao.findByUserIdAndVideoId(userId, videoId);
	}

	@Override
	public Like create(User user, Video video) {
		Like existLike = findByUserIdAndVideoId(user.getId(), video.getId());
		if (existLike == null) {
			existLike = new Like();
			existLike.setUser(user);
			existLike.setVideo(video);
			existLike.setViewDate(new Timestamp(System.currentTimeMillis()));
			existLike.setIsLike(Boolean.FALSE);
			return dao.create(existLike);
		}
		return existLike;
	}

	@Override
	public Like delete(Like entity) {
		return null;
	}

	@Override
	public boolean updateLikeOrUnlike(User user, String videoHref) {
		Video video = videoService.findByHref(videoHref);
		Like existLike = findByUserIdAndVideoId(user.getId(), video.getId());
		
		if (existLike.getIsLike() == Boolean.FALSE) {
			existLike.setIsLike(Boolean.TRUE);
			existLike.setLikeDate(new Timestamp(System.currentTimeMillis()));
		} else {
			existLike.setIsLike(Boolean.FALSE);
			existLike.setLikeDate(null);
		}
		Like updatedLike = dao.update(existLike);
		return updatedLike != null ? true : false;
	}
}
