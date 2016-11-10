package edu.nju.rms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@Auth(Role.ADMIN)
	@RequestMapping(value="/home")
	public String getRiskProjectList(ModelMap model) {
		List<RiskProject> projects = riskService.getAllRiskProject();
		model.put("projects", projects);
		return "/risk/project_list";
	}

}
