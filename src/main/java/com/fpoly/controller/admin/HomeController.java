package com.fpoly.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpoly.constant.SessionAttr;
import com.fpoly.dto.UserDto;
import com.fpoly.dto.VideoLikedInfo;
import com.fpoly.entity.User;
import com.fpoly.service.StatsService;
import com.fpoly.service.UserService;
import com.fpoly.service.impl.StatsServiceImpl;
import com.fpoly.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/admin", "/favorite"}, name = "HomeControllerOfAdmin")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = -6575163495524498186L;

	private StatsService statsService = new StatsServiceImpl();
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		
		if (currentUser != null && currentUser.getRole() == Boolean.TRUE) {
			String path = req.getServletPath();
			switch (path) {
			case "/admin":
				doGetHome(req, resp);
				break;
			case "/favorite":
				doGetFavorite(req, resp);
				break;
			}
		} else {
			resp.sendRedirect("index");
		}
	}
	
	private void doGetHome(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		List<VideoLikedInfo> videos = statsService.findVideoLikedInfo();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
	}
	
	//localhost:8080/java4asmv5/admin/favorite?href={videoHref}
	private void doGetFavorite(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String videoHref = req.getParameter("href");
		List<UserDto> users = userService.findUsersLikedVideoByVideoHref(videoHref);
		if (users.isEmpty())
			resp.setStatus(400);
		else {
			ObjectMapper mapper = new ObjectMapper();
			String dataResponse = mapper.writeValueAsString(users);
			resp.setStatus(200);
			out.print(dataResponse);
			out.flush();
		}
			
		
	}
}
