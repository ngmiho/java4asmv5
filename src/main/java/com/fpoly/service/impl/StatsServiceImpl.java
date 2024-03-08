package com.fpoly.service.impl;

import java.util.List;

import com.fpoly.dao.StatsDAO;
import com.fpoly.dao.impl.StatsDAOImpl;
import com.fpoly.dto.VideoLikedInfo;
import com.fpoly.service.StatsService;

public class StatsServiceImpl implements StatsService {
	
	private StatsDAO statsDAO;
	
	public StatsServiceImpl() {
		statsDAO = new StatsDAOImpl();
	}
	
	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		return statsDAO.findVideoLikedInfo();
	}

}
