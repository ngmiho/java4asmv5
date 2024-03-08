package com.fpoly.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fpoly.constant.SessionAttr;
import com.fpoly.entity.User;
import com.fpoly.entity.Video;
import com.fpoly.service.VideoService;
import com.fpoly.service.impl.VideoServiceImpl;

@WebServlet(urlPatterns = {"/admin/video"}, name = "VideoControlleerOfAdmin")
public class VideoController extends HttpServlet {

	private static final long serialVersionUID = -8467979424308420046L;
	
	private VideoService videoService = new VideoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if (currentUser != null && currentUser.getStatus() == Boolean.TRUE) {
			String action = req.getParameter("action");
			switch (action) {
				case "view":
					doGetOverView(req, resp);
					break;
				case "delete":
					doGetDelete(req, resp);
					break;
				case "add":
					req.setAttribute("isEdit", false);
					doGetAdd(req, resp);
					break;
				case "edit":
					req.setAttribute("isEdit", true);
					doGetEdit(req, resp);
					break;
			}
		} else {
			resp.sendRedirect("index");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if (currentUser != null && currentUser.getStatus() == Boolean.TRUE) {
			String action = req.getParameter("action");
			switch (action) {
				case "add":
					doPostAdd(req, resp);
					break;
				case "edit":
					doPostEdit(req, resp);
					break;
			}
		} else {
			resp.sendRedirect("index");
		}
	}
	
	// /java4asmv5/admin/video?action=view
	private void doGetOverView(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		List<Video> videos = videoService.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/video-overview.jsp").forward(req, resp);
	}
	// /java4asmv5/admin/video?action=add
	private void doGetAdd(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
	}
	// /java4asmv5/admin/video?action=edit&href={href}
	private void doGetEdit(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String href = req.getParameter("href");
		Video video = videoService.findByHref(href);
		req.setAttribute("video", video);
		req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
	}
	// /java4asmv5/admin/video?action=delete&href={href}
	private void doGetDelete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("application/json");
		String href = req.getParameter("href");
		Video videoDeleted = videoService.delete(href);
		if (videoDeleted != null) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
		List<Video> videos = videoService.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/video-overview.jsp").forward(req, resp);
	}
	
	private void doPostAdd(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("application/json");
		String title = req.getParameter("title");
		String detail = req.getParameter("detail");
		String href = req.getParameter("href");
		String poster = req.getParameter("poster");
		
		Video video = new Video();
		video.setTitle(title);
		video.setHref(href);
		video.setDetail(detail);

		Video videoReturn = videoService.create(video);
		if (videoReturn != null)
			resp.setStatus(204);
		else
			resp.setStatus(400);
	}
	private void doPostEdit(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("application/json");
		String title = req.getParameter("title");
		String detail = req.getParameter("detail");
		String href = req.getParameter("newHref");
		String poster = req.getParameter("poster");
		String hrefOrigin = req.getParameter("hrefOrigin");
		
		Video video = videoService.findByHref(hrefOrigin);
		video.setTitle(title);
		video.setHref(href);
		video.setDetail(detail);

		
		Video videoReturn = videoService.update(video);
		if (videoReturn != null)
			resp.setStatus(204);
		else
			resp.setStatus(400);
	}
	private void doPostDelete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("application/json");
		String title = req.getParameter("title");
		String detail = req.getParameter("detail");
		String href = req.getParameter("href");
		String poster = req.getParameter("poster");
		
		Video video = new Video();
		video.setTitle(title);
		video.setHref(href);
		video.setDetail(detail);

		
		List<Video> videos = videoService.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/video-edit.jsp").forward(req, resp);
	}
}
