package pe.edu.upc.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.spring.service.IOwnerService;
import pe.edu.upc.spring.service.IServiceRequestService;
import pe.edu.upc.spring.service.IWalkerService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private IServiceRequestService srService;

	@Autowired
	private IOwnerService owService;

	@Autowired
	private IWalkerService waService;

	@RequestMapping("/ingresar")
	public String irPaginaLogin() {
		return "login";
	}
	
	
	

	
}
