package com.fpoly.controller;

import java.io.IOException;

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

@WebServlet(urlPatterns = "/video")
public class VideoController extends HttpServlet {

	private static final long serialVersionUID = 7857394506560792709L;
	
	private VideoService videoService = new VideoServiceImpl();
	private LikeService likeService = new LikeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String actionParam = req.getParameter("action");
		String href = req.getParameter("id");
		HttpSession session = req.getSession();
		
		switch (actionParam) {
			case "watch":
				doGetWatch(session, href, req, resp);
				break;
			case "like":
				doGetLike(session, href, req, resp);
				break;
		}
	}
	
	//localhost:8080//java4asm/video?action=watch&id={href}
	private void doGetWatch(HttpSession session, String href, HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Video video = videoService.findByHref(href);
		
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		
		if (currentUser != null) {
			Like like = likeService.create(currentUser, video);
			req.setAttribute("flagLikedBtn", like.getIsLike());
		}
		
		
		req.setAttribute("video", video);
		req.getRequestDispatcher("/views/video-detail.jsp").forward(req, resp);
	}
	
	//localhost:8080//java4asm/video?action=like&id={href}
	private void doGetLike(HttpSession session, String href, HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("application/json");
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		boolean result = likeService.updateLikeOrUnlike(currentUser, href);
		if (result == true) {
			resp.setStatus(204); //succeed but no data
		} else {
			resp.setStatus(400);
		}
	}
	
}
