package com.fpoly.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fpoly.dao.UserDAO;
import com.fpoly.dao.impl.UserDAOImpl;
import com.fpoly.dto.UserDto;
import com.fpoly.entity.User;
import com.fpoly.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDAO dao;
	
	public UserServiceImpl() {
		dao = new UserDAOImpl();
	}
	
	@Override
	public User findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

	@Override
	public User login(String username, String password) {
		return dao.findByUsernameAndPassword(username, password);
	}

	@Override
	public User resetPassword(String email) {
		User existUser = findByEmail(email);
		if (existUser != null) {
			//1000 - 9999
			// (Math.random()) * ((max - min) + 1)) + min
			String newPass = String.valueOf((int) (Math.random() * ((9999 - 1000) + 1)) + 1000);
			existUser.setPassword(newPass);
			return dao.update(existUser);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		return dao.findAll(pageNumber, pageSize);
	}

	@Override
	public User create(String username, String password, String email) {
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password); //bcrypt md5
		newUser.setEmail(email);
		newUser.setRole(Boolean.TRUE);
		newUser.setStatus(Boolean.TRUE);
		return dao.create(newUser);
	}

	@Override
	public User update(User entity) {
		return dao.update(entity);
	}

	@Override
	public User delete(String username) {
		User user = dao.findByUsername(username);
		user.setStatus(Boolean.FALSE);
		return dao.update(user);
	}

	@Override
	public List<UserDto> findUsersLikedVideoByVideoHref(String href) {
		Map<String, Object> params = new HashMap<>();
		params.put("videoHref", href);
		List<User> users = dao.findUserLikedVideoByVideoHref(params);
		List<UserDto> result = new ArrayList<>();
		users.forEach(user -> {
			UserDto dto = new UserDto();
			dto.setUsername(user.getUsername());
			dto.setEmail(user.getEmail());
			result.add(dto);
		});
		return result;
	}
	
}
