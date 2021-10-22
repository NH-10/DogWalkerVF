package pe.edu.upc.spring.controller;

//import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Owner;
import pe.edu.upc.spring.model.Dog;
import pe.edu.upc.spring.model.Race;
import pe.edu.upc.spring.model.Character;

import pe.edu.upc.spring.service.IDogService;
//import pe.edu.upc.spring.service.IOwnerService;
import pe.edu.upc.spring.service.IRaceService;
import pe.edu.upc.spring.service.ICharacterService;

@Controller
@RequestMapping("/pantalla") 
public class controller {
	
	@RequestMapping("/regitrarSegunUsuario")
	public String irPaginaBienvenida() {
		return "registrarSegunUsuario"; 
	}
	
		
	
}
