package com.fpoly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fpoly.constant.SessionAttr;
import com.fpoly.entity.Like;
import com.fpoly.entity.User;
import com.fpoly.entity.Video;
import com.fpoly.service.LikeService;
import com.fpoly.service.VideoService;
import com.fpoly.service.impl.LikeServiceImpl;
import com.fpoly.service.impl.VideoServiceImpl;

@WebServlet(urlPatterns = {"/index", "/favorites", "/history"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 7864189457089935760L;
	
	private static final int VIDEO_MAX_PAGE_SIZE = 3;
	private VideoService videoService = new VideoServiceImpl();
	private LikeService likeService = new LikeServiceImpl();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/index":
			doGetIndex(req, resp);
			break;
		case "/favorites":
			doGetFavorites(session, req, resp);
			break;
		case "/history":
			doGetHistory(session, req, resp);
			break;
		}

	}
	
	//localhost:8080/asm-java4/index?page=
	private void doGetIndex(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		List<Video> countVideo = videoService.findAll();
		int maxPage = (int) Math.ceil(countVideo.size() / (double) VIDEO_MAX_PAGE_SIZE);
		req.setAttribute("maxPage", maxPage);
		String pageNumber = req.getParameter("page");
		
		List<Video> videos;
		if (pageNumber == null || Integer.valueOf(pageNumber) > maxPage) {
			videos = videoService.findAll(1, VIDEO_MAX_PAGE_SIZE);
			req.setAttribute("currentPage", 1);
		} else {
			videos = videoService.findAll(Integer.valueOf(pageNumber), VIDEO_MAX_PAGE_SIZE);
			req.setAttribute("currentPage", Integer.valueOf(pageNumber));
		}

		req.getSession().setAttribute("lstVideo", videos);
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}
	private void doGetFavorites(HttpSession session, HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<Like> histories = likeService.findByUserAndIsLiked(user.getUsername());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		/*
		 	for (int i = 0; i < histories.size(); i++) {
		 		videos.add(histories.get(i).getVideo();
		 
		 */
		req.getSession().setAttribute("lstVideo", videos);
		req.getRequestDispatcher("/views/favorites.jsp").forward(req, resp);
	}
	private void doGetHistory(HttpSession session, HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<Like> histories = likeService.findByUser(user.getUsername());
		List<Video> videos = new ArrayList<>();
		histories.forEach(item -> videos.add(item.getVideo()));
		/*
		 	for (int i = 0; i < histories.size(); i++) {
		 		videos.add(histories.get(i).getVideo();
		 
		 */
		req.getSession().setAttribute("lstVideo", videos);
		req.getRequestDispatcher("/views/history.jsp").forward(req, resp);
	}

}
