package edu.nju.rms.controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.nju.rms.interceptor.Auth;
import edu.nju.rms.interceptor.Role;
import edu.nju.rms.model.RiskItem;
import edu.nju.rms.model.RiskProject;
import edu.nju.rms.model.RiskTrigger;
import edu.nju.rms.model.TrackItem;
import edu.nju.rms.model.User;
import edu.nju.rms.service.ProjectService;
import edu.nju.rms.service.RiskService;
import edu.nju.rms.service.UserService;

@Controller
@RequestMapping(value="/risk")
public class RiskController {
	
	private RiskService riskService;
	
	private ProjectService projectService;
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setRiskService(RiskService riskService) {
		this.riskService = riskService;
	}
	
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@Auth(Role.USER)
	@RequestMapping(value="/add/{projectId}", method=RequestMethod.GET)
	public String getAddRisk(HttpServletRequest request, ModelMap model, @PathVariable int projectId) {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		RiskProject project = projectService.getProjectById(projectId);
		List<User> users = userService.getAllUsers();
		if (project.getCreater() == uid){
			model.put("uploader", true);
			model.put("project", project);
			model.put("users", users);
		}
		return "/risk/add_risk";
	}
	
	@Auth(Role.USER)
	@RequestMapping(value="/edit/{riskId}", method=RequestMethod.GET)
	public String getEdit(HttpServletRequest request, ModelMap model, @PathVariable int riskId) {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		RiskItem risk = riskService.getRiskItemById(riskId);
		RiskProject project = risk.getProject();
		List<User> users = userService.getAllUsers();
		if (project.getCreater() == uid){
			model.put("uploader", true);
			model.put("project", project);
			model.put("users", users);
			model.put("risk", risk);
		} 
		return "/risk/edit_risk";
	}
	
	@Auth(Role.USER)
	@RequestMapping(value="/edit/{riskId}", method=RequestMethod.POST)
	public void postEdit(HttpServletRequest request,HttpServletResponse response, ModelMap model, @PathVariable int riskId,
			@RequestParam int projectId, @RequestParam String title, @RequestParam String content, 
			@RequestParam int chance, @RequestParam int influence,
			@RequestParam int follwer) throws IOException {
		RiskItem item = riskService.getRiskItemById(riskId);
		item.setTitle(title);
		item.setContent(content);
		item.setCtime(new Date());
		item.setFollower(userService.getUser(follwer));
		item.setLevelChance(chance);
		item.setLevelInfluence(influence);
		riskService.updateRiskItem(item);
		response.sendRedirect(request.getContextPath() + "/risk/risk_list/" + projectId);
	}
	
	@Auth(Role.USER)
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addRisk(HttpServletRequest request, HttpServletResponse response,
			ModelMap model, @RequestParam int projectId,
			@RequestParam String title, @RequestParam String content, @RequestParam int chance, @RequestParam int influence,
			@RequestParam String trigger, @RequestParam int follwer) throws IOException {
		// TODO
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		RiskItem item = new RiskItem();
		item.setContent(content);
		item.setCtime(new Date());
		item.setLevelChance(chance);
		item.setLevelInfluence(influence);
		item.setTitle(title);
		User uploader = userService.getUser(uid);
		item.setUploader(uploader);

		User follower = userService.getUser(follwer);
		item.setFollower(follower);
		
		RiskProject project = projectService.getProjectById(projectId);
		item.setProject(project);
		
		RiskTrigger triggerItem = new RiskTrigger();
		triggerItem.setContent(trigger);
		Set<RiskTrigger> triggers = (Set<RiskTrigger>) new HashSet();
		triggers.add(triggerItem);
		item.setTriggers(triggers);
		
		riskService.addRiskItem(item);
		response.sendRedirect(request.getContextPath() + "/risk/risk_list/" + projectId);
	}
	
	@Auth(Role.USER)
	@RequestMapping(value="/risk_list/{projectId}", method=RequestMethod.GET)
	public String riskList(HttpServletRequest request, ModelMap model, @PathVariable int projectId) {
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		RiskProject project = projectService.getProjectById(projectId);
		List<RiskItem> riskItems = riskService.getRiskItemByProjectId(projectId);
		if (project.getCreater() == uid){
			model.put("uploader", true);
		}
		model.put("risks", riskItems);
		model.put("project", project);
		model.put("total", riskItems.size());
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
	
	@Auth(Role.ADMIN)
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteUser(HttpServletRequest request, @RequestParam String ids) {
		boolean result = riskService.deleteRisks(ids);
		Map<String, Object> map = new HashMap<String, Object>();  
		map.put("result", result?1:0);
		return map;
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
