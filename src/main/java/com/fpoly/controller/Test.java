package com.fpoly.controller;

import com.fpoly.entity.User;
import com.fpoly.service.impl.UserServiceImpl;

public class Test {
	public static void main(String[] args) {
		for (User user : new UserServiceImpl().findAll()) {
			System.out.println(user.getId());
		}
	}
}
