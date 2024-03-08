package com.fpoly.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.fpoly.dao.AbstractDAO;
import com.fpoly.dao.StatsDAO;
import com.fpoly.dto.VideoLikedInfo;
import com.fpoly.entity.User;

public class StatsDAOImpl extends AbstractDAO<Object[]> implements StatsDAO {

	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		String jpql = "SELECT v.Id, v.Title, v.Href, sum(cast(l.IsLike as int)) as totalLike "
				+ "FROM Videos v left join Likes l on v.id = l.VideoId "
				+ "WHERE v.Status = 1 "
				+ "GROUP BY v.Id, v.Title, v.Href "
				+ "ORDER BY sum(cast(l.IsLike as int)) DESC";
		List<Object[]> objects = super.findManyByNativeQuery(jpql);
		List<VideoLikedInfo> result = new ArrayList<>();
		objects.forEach(object -> {
			VideoLikedInfo videoLikedInfo = setDataVideoLikedInfo(object);
			result.add(videoLikedInfo);
		});
		return result;
	}
	
	private VideoLikedInfo setDataVideoLikedInfo(Object[] object) {
		VideoLikedInfo videoLikedInfo = new VideoLikedInfo();
		videoLikedInfo.setVideoId((Integer) object[0]);
		videoLikedInfo.setTitle((String) object[1]);
		videoLikedInfo.setHref((String) object[2]);
		videoLikedInfo.setTotalLike(object[3] == null ? 0 : (Integer) object[3]);
		return videoLikedInfo;
	}
}
