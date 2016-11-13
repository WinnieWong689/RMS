package edu.nju.rms.controller;

import edu.nju.rms.interceptor.Auth;
import edu.nju.rms.interceptor.Role;
import edu.nju.rms.model.RiskProject;
import edu.nju.rms.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value="")
public class ProjectController {

	private ProjectService projectService;

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@Auth(Role.USER)
	@RequestMapping(value="/home")
	public String getRiskProjectList(ModelMap model) {
		List<RiskProject> projects = projectService.getAllRiskProject();
		model.put("projects", projects);
		return "/risk/project_list";
	}

	@Auth(Role.USER)
	@RequestMapping(value="/risk/add", method= RequestMethod.GET)
	public String addRiskProject(HttpServletRequest req) {
//		TODO just for test
//		Integer uid = (Integer) req.getSession().getAttribute("uid");
//		if (uid != null) {
//			riskService.addRiskProject("test", "This is a test project", uid);
//		}
		return "/risk/project_list";
	}
}
