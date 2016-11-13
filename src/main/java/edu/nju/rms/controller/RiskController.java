package edu.nju.rms.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.nju.rms.interceptor.Auth;
import edu.nju.rms.interceptor.Role;
import edu.nju.rms.model.RiskProject;
import edu.nju.rms.service.RiskService;

@Controller
@RequestMapping(value="")
public class RiskController {
	
	private RiskService riskService;
	
	public void setRiskService(RiskService riskService) {
		this.riskService = riskService;
	}	
	

	
	@Auth(Role.USER)
	@RequestMapping(value="/risk/risk_track_list", method=RequestMethod.GET)
	public String add(HttpServletRequest request, ModelMap model) {
		return "/risk/risk_track_list";
	}
	
	@Auth(Role.FOLLOWER)
	@RequestMapping(value="/risk/add_track_item", method=RequestMethod.GET)
	public String showRiskItemList(HttpServletRequest request,ModelMap model) {
		return "/risk/add_track_item";
	}
	
	@Auth(Role.FOLLOWER)
	@RequestMapping(value="/risk/add_track_item", method=RequestMethod.POST)
	public void addRiskItem(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int result = -1;
		if (title != null && description != null) {
			//result = userService.addUser(username, nickname, password, role);
		}
		if (result == -1) {
			request.getRequestDispatcher("/user/addmsg").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/risk_track_list");
		}
	}
}
