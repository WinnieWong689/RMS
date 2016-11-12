package edu.nju.rms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.nju.rms.interceptor.Auth;
import edu.nju.rms.interceptor.Role;
import edu.nju.rms.model.User;
import edu.nju.rms.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Auth(Role.ADMIN)
	@RequestMapping(value="")
	public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("total", users.size());
		return "/user/user_list";
	}
	
	@Auth(Role.ADMIN)
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(HttpServletRequest request, ModelMap model) {
		return "/user/new_user";
	}
	
	@Auth(Role.ADMIN)
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addUser(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException {
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		Integer role = Integer.parseInt(request.getParameter("role"));
		int result = -1;
		if (username != null && nickname != null && password != null && role != null) {
			result = userService.addUser(username, nickname, password, role);
		}
		if (result == -1) {
			request.getRequestDispatcher("/user/addmsg").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/user");
		}
	}
	
	@RequestMapping(value="/addmsg")
	public String addFailed(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "/user/add_failed";
	}
}
