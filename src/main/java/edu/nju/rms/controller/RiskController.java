package edu.nju.rms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	@RequestMapping(value="/home")
	public String getRiskProjectList(ModelMap model) {
		List<RiskProject> projects = riskService.getAllRiskProject();
		model.put("projects", projects);
		return "/risk/project_list";
	}

	@Auth(Role.USER)
	@RequestMapping(value="/risk/add", method=RequestMethod.GET)
	public String addRiskProject(HttpServletRequest req) {
//		TODO just for test
//		Integer uid = (Integer) req.getSession().getAttribute("uid");
//		if (uid != null) {
//			riskService.addRiskProject("test", "This is a test project", uid);
//		}
		return "/risk/project_list";
	}
	
	@Auth(Role.USER)
	@RequestMapping(value="/risk/risk_track_list", method=RequestMethod.GET)
	public String add(HttpServletRequest request, ModelMap model) {
		return "/risk/risk_track_list";
	}
	
	@Auth(Role.FOLLOWER)
	@RequestMapping(value="/risk/new_track_item", method=RequestMethod.GET)
	public void addRiskItem(HttpServletRequest request,ModelMap model) {
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
