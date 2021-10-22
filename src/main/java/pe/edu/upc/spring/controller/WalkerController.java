package pe.edu.upc.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.sun.el.parser.ParseException;

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
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("walker", new Walker());
		model.addAttribute("listadistrito", dService.listDistrict());
		model.addAttribute("listpersonalidad", pService.listPersonality());
		return "owner"; 
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
			if (flag)
				return "redirect:/walker/bienvenido";
			else {
				model.addAttribute("mensaje","Ocurrio un error");
				return "redirect:/walker/irRegistrar";
			}
		}
	}
	
	
}
