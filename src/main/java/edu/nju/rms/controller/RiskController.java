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
}
