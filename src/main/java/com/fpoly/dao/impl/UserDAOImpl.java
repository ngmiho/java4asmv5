package com.fpoly.dao.impl;

import java.util.List;
import java.util.Map;

import com.fpoly.constant.NamedStored;
import com.fpoly.dao.AbstractDAO;
import com.fpoly.dao.UserDAO;
import com.fpoly.entity.User;

public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

	@Override
	public User findById(Integer id) {
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		String jpql = "SELECT o FROM User o WHERE o.email = ?0";
		return super.findOne(User.class, jpql, email);
	}

	@Override
	public User findByUsername(String username) {
		String jpql = "SELECT o FROM User o WHERE o.username = ?0";
		return super.findOne(User.class, jpql, username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		String jpql = "SELECT o FROM User o WHERE o.username = ?0 AND o.password = ?1";
		return super.findOne(User.class, jpql, username, password);
	}

	@Override
	public List<User> findAll() {
		return super.findAll(User.class, true);
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return super.findAll(User.class, true, pageNumber, pageSize);
	}

	@Override
	public List<User> findUserLikedVideoByVideoHref(Map<String, Object> params) {
		return super.callStored(NamedStored.FIND_USERS_LIKED_VIDEO_BY_VIDEO_HREF, params);
	}
}
