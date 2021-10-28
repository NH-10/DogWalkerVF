package pe.edu.upc.spring.controller;

import java.util.List;
import java.util.Map;

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
	
	@Autowired
	private ServiceRequestController sController;

	private Walker sesionWalker;

	@RequestMapping("/inicio")
	public String irPaginaInicio() {
		return "bienvenido";
	}

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida(Model model) {
		model.addAttribute("walker", sesionWalker);
		return "bienvenidoWalker";
	}

	@RequestMapping("/menu")
	public String irMenuWalker() {
		return "menuWalker";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar() {
		return "walkerListByDistrict";
	}

	@RequestMapping("/irRegistrar") // función registrar paseador
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("walker", new Walker());
		model.addAttribute("listadistrito", dService.listDistrict());
		model.addAttribute("listpersonalidad", pService.listPersonality());
		return "walker";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Walker objWalker, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listadistrito", dService.listDistrict());
			model.addAttribute("listpersonalidad", pService.listPersonality());
			return "walker";
		} else {
			boolean flag = wService.save(objWalker);
			if (flag) {
				
				sesionWalker = objWalker;
				sController.setWalker(sesionWalker);
				return "redirect:/walker/bienvenido";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/walker/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar")
	public String modificar(Model model) {
		model.addAttribute("walker", sesionWalker);
		model.addAttribute("listadistrito", dService.listDistrict());
		model.addAttribute("listpersonalidad", pService.listPersonality());
		return "walkerEdit";

	}
	
	
	@RequestMapping("/validarUsuario")
	public String ingresarCuenta(@ModelAttribute Walker objWalker) throws ParseException {
		List<Walker> listWalkers;
		objWalker.setEmail(objWalker.getEmail());
		objWalker.setPassword(objWalker.getPassword());
		listWalkers = wService.findByEmailAndPassword(objWalker.getEmail(), objWalker.getPassword());

		if (!listWalkers.isEmpty()) {
			objWalker = listWalkers.get(0);

			sesionWalker = objWalker;
			return "redirect:/walker/bienvenido";
		}
		else
		return "walkerLogin";
	}
	
	@RequestMapping("/buscar")
	public String buscarPorDistrito(Map<String, Object> model, @ModelAttribute Walker walker) throws ParseException 
	{ 
		List<Walker> listWalkersbyDistrict;
		walker.setDistrict(walker.getDistrict());
		listWalkersbyDistrict = wService.listByDistrict(walker.getDistrict().getName());
		
		if(listWalkersbyDistrict.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}	
		model.put("listWalkersbyDistrict", listWalkersbyDistrict);
		return "walkerListByDistrict";
	}
	
	/*
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listarPaseadores", wService.list());
		return "walkerListByDistrict";
	}
	*/
}
