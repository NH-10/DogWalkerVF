package pe.edu.upc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.spring.model.District;

@Controller
@RequestMapping("/pantalla") 
public class HomeController {
	
	@RequestMapping("/inicio")
	public String PaginaBienvenida(Model model) {
		model.addAttribute("district", new District());
		return "bienvenido2"; 
	}
	@RequestMapping("/quienessomos")
	public String PaginaquienesSomos() {
		return "quienessomos"; 
	}
	@RequestMapping("/contactanos")
	public String Paginacontactanos() {
		return "contactanos"; 
	}
	
	@RequestMapping("/regitrarSegunUsuario")
	public String irPaginaBienvenida() {
		return "registrarSegunUsuario"; 
	}
	
	@RequestMapping("/iniciarSegunUsuario")
	public String irPagina() {
		return "iniciarSegunUsuario"; 
	}
	@RequestMapping("/cerrarSesion")
	public String cerrarSesion() {
		return "bienvenido"; 
	}
			
	
	
}
