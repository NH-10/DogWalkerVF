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
@RequestMapping("/dog") 
public class DogController {
	@Autowired
	private IDogService dService;
	
	//@Autowired
	//private IOwnerService oService;
	
	@Autowired
	private IRaceService rService;
	
	@Autowired
	private ICharacterService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; 
	}
	
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("dog", new Dog());
		model.addAttribute("listaRaza", rService.listar());
		model.addAttribute("listaCaracter", cService.listCharacter());
		//model.addAttribute("listaDueno", oService.list());
		return "dog"; 
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Dog objDog, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
		{
			model.addAttribute("listaRaza", rService.listar());
			model.addAttribute("listaCaracter", cService.listCharacter());
			return "dog";
		}
		else {
			boolean flag = dService.save(objDog);
			if (flag)
				return "redirect:/dog/listar";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/dog/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
		throws ParseException
	{
		Optional<Dog> objDog = dService.listById(id);
		if (objDog == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/dog/listar";
		}
		else {
			model.addAttribute("listaRaza", rService.listar());
			model.addAttribute("listaCaracter", cService.listCharacter());
			
			if(objDog.isPresent())
				objDog.ifPresent(d -> model.addAttribute("dog",d));
			return "dog";
		}
	}
		
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model,  @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				dService.delete(id);
				model.put("listDogs", dService.list());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listDogs", dService.list());
		}
		return "listDog";
	}
		
	
}
