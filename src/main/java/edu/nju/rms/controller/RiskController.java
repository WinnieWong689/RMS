package edu.nju.rms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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
import edu.nju.rms.model.TrackItem;
import edu.nju.rms.service.RiskService;

@Controller
@RequestMapping(value="/risk")
public class RiskController {
	
	private RiskService riskService;

	public void setRiskService(RiskService riskService) {
		this.riskService = riskService;
	}
	
	@Auth(Role.USER)
	@RequestMapping(value="/risk_list/{projectId}", method=RequestMethod.GET)
	public String riskList(HttpServletRequest request, ModelMap model, @PathVariable int projectId) {
		List<RiskItem> riskItems = riskService.getRiskItemByProjectId(projectId);
		model.put("risks", riskItems);
		return "/risk/risk_list";
	}
	
	@Auth(Role.USER)
	@RequestMapping(value="/risk_track_list/{itemId}", method=RequestMethod.GET)
	public String show(HttpServletRequest request, ModelMap model, @PathVariable int itemId) {
		RiskItem riskItem = riskService.getRiskItemById(itemId);
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if (riskItem != null) {
			List<TrackItem> trackItems = riskService.getTrackItemByRiskItemId(itemId);
			if (uid== riskItem.getFollower().getId()) {
				model.put("follower", true);
			}
			model.put("project", riskItem.getProject());
			model.put("riskItem", riskItem);
			model.put("trackItems", trackItems);
			model.put("trackCount", riskItem.getTrackItems().size());
		} else {
			model.put("error", true);
		}
		return "/risk/risk_track_list";
	}
	
	@Auth(Role.FOLLOWER)
	@RequestMapping(value="/add_track_item/{itemId}", method=RequestMethod.GET)
	public String addTrackItem(HttpServletRequest request,ModelMap model, @PathVariable int itemId) {
		model.put("itemId", itemId);
		return "/risk/add_track_item";
	}
	
	@Auth(Role.FOLLOWER)
	@RequestMapping(value="/add_track_item", method=RequestMethod.POST)
	public void addRiskItem(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int result = -1;
		if (title != null && description != null) {
			result = riskService.addTrackItem(itemId, title, description);
		}
		if (result == -1) {
			request.getRequestDispatcher("/user/addmsg").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/risk/risk_track_list/" + itemId);
		}
	}
	
	public class TrackItemComparator implements Comparator<TrackItem> {

		@Override
		public int compare(TrackItem o1, TrackItem o2) {
			TrackItem t1 = (TrackItem) o1;
			TrackItem t2 = (TrackItem) o2;
			return t2.getCtime().compareTo(t1.getCtime());
		}
	}
}
