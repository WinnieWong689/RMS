package edu.nju.rms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import edu.nju.rms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.nju.rms.interceptor.Auth;
import edu.nju.rms.interceptor.Role;
import edu.nju.rms.model.RiskProject;
import edu.nju.rms.service.ProjectService;

@Controller
@RequestMapping(value="/project")
public class ProjectController {

	private ProjectService projectService;

	private UserService userService;

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Auth(Role.USER)
	@RequestMapping(value="")
	public String getRiskProjectList(ModelMap model) {
		List<RiskProject> projects = projectService.getAllRiskProject();
		model.put("projects", projects);
		return "/project/project_list";
	}
	
	@Auth(Role.USER)
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addProject(ModelMap model, HttpServletRequest request) {
		Integer uid =  (Integer) request.getSession().getAttribute("uid");
		int role = userService.getRole(uid);
		model.put("role", role);
		return "/project/new_project";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> addProject(HttpServletRequest request, @RequestParam String name, 
			@RequestParam String description) {
		Integer uid =  (Integer) request.getSession().getAttribute("uid");
		boolean result = projectService.addRiskProject(name, description, uid);
		Map<String, Object> map = new HashMap<String, Object>();  
		map.put("result", result?1:0);
		return map;
	}

}
