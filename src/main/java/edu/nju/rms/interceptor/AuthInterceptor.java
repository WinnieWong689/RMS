package edu.nju.rms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	@Override    
    public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) throws Exception {
		if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
			
			Auth auth = ((HandlerMethod)handler).getMethodAnnotation(Auth.class);
			if (auth != null) {
				HttpSession session = request.getSession();
				if (request.getMethod().equals("GET")) {
					// ╫ги╚еп╤о
					Integer uid = (Integer) session.getAttribute("uid");
					if (uid == null 
						|| (auth.value() == Role.ADMIN && session.getAttribute("admin") == null)) {
						response.sendRedirect(request.getContextPath() + "/");
						return false;
					}
				}
			}
		}
		return true;
	}

}
