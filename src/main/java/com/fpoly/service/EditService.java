package com.fpoly.service;

import java.util.List;

import com.fpoly.entity.Edit;

public interface EditService {
	List<Edit> findByUser(String username);
	List<Edit> findByUserAndIsLiked(String username);
	Edit findByUserIdAndVideoId(Integer userId, Integer videoId);
	Edit create(Edit entity);
	Edit update(Edit entity);
}
