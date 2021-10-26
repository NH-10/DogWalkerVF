package pe.edu.upc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pantalla") 
public class controller {
	
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
