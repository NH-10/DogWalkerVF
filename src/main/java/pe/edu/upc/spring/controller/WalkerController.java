package pe.edu.upc.spring.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Owner;
import pe.edu.upc.spring.model.Walker;

import pe.edu.upc.spring.service.IDistrictService;
import pe.edu.upc.spring.service.IPersonalityService;
import pe.edu.upc.spring.service.IWalkerService;


@Controller
@RequestMapping("/walker") 
public class WalkerController {
	
	@Autowired
	private IDistrictService dService;
	
	@Autowired
	private IPersonalityService pService;
	
	@Autowired
	private IWalkerService wService;
	

	private Walker sesionWalker;
	
	@RequestMapping("/inicio")
	public String irPaginaInicio() {
		return "bienvenido";
	}
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenidoWalker";
	}
	
	@RequestMapping("/menu")
	public String irMenuWalker() {
		return "menuWalker";
	}
	
	@RequestMapping("/irRegistrar")  // función registrar paseador
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("walker", new Walker());
		model.addAttribute("listadistrito", dService.listDistrict());
		model.addAttribute("listpersonalidad", pService.listPersonality());
		return "walker"; 
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Walker objWalker, BindingResult binRes, Model model) 
		throws ParseException
	{
		if (binRes.hasErrors())
		{
			model.addAttribute("listadistrito", dService.listDistrict());
			model.addAttribute("listpersonalidad", pService.listPersonality());
			return "walker";
		}
		else {
			boolean flag = wService.save(objWalker);
			if (flag) {
				sesionWalker= objWalker;
				return "redirect:/walker/bienvenido";
			}
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/walker/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar")
	public String modificar(Model model)  {
		model.addAttribute("walker", sesionWalker);
		model.addAttribute("listadistrito", dService.listDistrict());
		model.addAttribute("listpersonalidad", pService.listPersonality());
		return "walkerEdit";
		
	}
}
