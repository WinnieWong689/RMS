package edu.nju.rms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.nju.rms.interceptor.Auth;
import edu.nju.rms.interceptor.Role;
import edu.nju.rms.model.RiskItem;
import edu.nju.rms.model.RiskProject;
import edu.nju.rms.model.TrackItem;
import edu.nju.rms.service.RiskService;

@Controller
@RequestMapping(value="")
public class RiskController {
	
	private RiskService riskService;

	public void setRiskService(RiskService riskService) {
		this.riskService = riskService;
	}

	@Auth(Role.USER)
	@RequestMapping(value="/risk/risk_track_list/{itemId}", method=RequestMethod.GET)
	public String show(HttpServletRequest request, ModelMap model, @PathVariable int itemId) {
		RiskItem riskItem = riskService.getRiskItemById(itemId);
		if (riskItem != null) {
			RiskProject project = riskItem.getProject();
			List<TrackItem> trackItems = riskService.getTrackItemByRiskItemId(itemId);
			model.put("project", project);
			model.put("riskItem", riskItem);
			model.put("trackItems", trackItems);
		} else {
			model.put("error", true);
		}
		return "/risk/risk_track_list";
	}
	
	@Auth(Role.FOLLOWER)
	@RequestMapping(value="/risk/add_track_item", method=RequestMethod.GET)
	public String addTrackItem(HttpServletRequest request,ModelMap model) {
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
