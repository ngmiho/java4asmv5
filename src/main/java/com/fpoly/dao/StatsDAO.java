package com.fpoly.dao;

import java.util.List;

import com.fpoly.dto.VideoLikedInfo;
import com.fpoly.entity.User;

public interface StatsDAO {
	
	List<VideoLikedInfo> findVideoLikedInfo();
}
