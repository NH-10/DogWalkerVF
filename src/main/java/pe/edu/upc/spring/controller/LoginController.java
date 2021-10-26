package pe.edu.upc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.spring.model.Owner;
import pe.edu.upc.spring.model.Walker;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	@RequestMapping("/loginOwner")
	public String irPaginaLoginOwner(Model model) {
		model.addAttribute("owner", new Owner());
		return "ownerLogin"; 
	}
	
	@RequestMapping("/loginWalker")
	public String irPaginaLoginWalker(Model model) {
		model.addAttribute("walker", new Walker());
		return "walkerLogin";
	}
	
	@RequestMapping("/iniciarSegunUsuario")
	public String irIniciarSegunUsuario() {
		return "iniciarSegunUsuario";
	}

}
