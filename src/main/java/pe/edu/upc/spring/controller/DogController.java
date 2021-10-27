package pe.edu.upc.spring.controller;

import java.util.List;
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


import pe.edu.upc.spring.model.Dog;
import pe.edu.upc.spring.model.Owner;
import pe.edu.upc.spring.service.IDogService;
import pe.edu.upc.spring.service.IOwnerService;
import pe.edu.upc.spring.service.IRaceService;
import pe.edu.upc.spring.service.ICharacterService;

@Controller
@RequestMapping("/dog") ///
public class DogController {
	@Autowired
	private IDogService dService;
	
	@Autowired
	private IOwnerService oService;
	
	@Autowired
	private IRaceService rService;
	
	@Autowired
	private ICharacterService cService;
	
	private String idOwner;
	private Owner sesionOwner;
	private String idOwner;
	private List<Dog> listDog;

	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido"; 
	}
	
	@RequestMapping("/menu")
	public String irMenuOwner() {
		return "dogMenu";
	}
	
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("dog", new Dog());
		model.addAttribute("owner", sesionOwner);
		model.addAttribute("listaRaza", rService.listRace());
		model.addAttribute("listaCaracter", cService.listCharacter());
		return "dog"; 
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Dog objDog, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
		{
			model.addAttribute("listaRaza", rService.listRace());
			model.addAttribute("listaCaracter", cService.listCharacter());
			model.addAttribute("owner", sesionOwner);
			return "dog";
		}
		else {
			boolean flag = dService.save(objDog);
			if (flag)
				return "redirect:/dog/menu";
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
			model.addAttribute("listaRaza", rService.listRace());
			model.addAttribute("listaCaracter", cService.listCharacter());
			model.addAttribute("listaDueno", oService.list());
			
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
	
	@RequestMapping("/listarCanes")
	public String listarCanes(Model model) 
	{
		idOwner = String.valueOf(sesionOwner.getIdOwner());
		listDog = dService.ListDogByOwner(idOwner);
		model.addAttribute("ListDogByOwner", listDog);
		return "dogList";
	}	
	
	public void setOwner(Owner o) {
		sesionOwner = o;
	}
	
	
	
}
