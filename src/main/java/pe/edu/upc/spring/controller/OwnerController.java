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

import pe.edu.upc.spring.model.Owner;
import pe.edu.upc.spring.service.IDistrictService;
import pe.edu.upc.spring.service.IDogService;
import pe.edu.upc.spring.service.IOwnerService;
import pe.edu.upc.spring.service.IServiceRequestService;

@Controller
@RequestMapping("/owner")
public class OwnerController {
	@Autowired
	private IOwnerService oService;

	@Autowired
	private IDistrictService dService;

	@Autowired
	private IDogService cService;
	
	@Autowired
	private ServiceRequestController sController;
	
	@Autowired
	private DogController dogController;
	

	private Owner sesionOwner;

	@RequestMapping("/inicio")
	public String irPaginaInicio() {
		return "bienvenido";
	}

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida(Model model) {
		model.addAttribute("owner", sesionOwner);
		return "bienvenidoOwner";
	}

	@RequestMapping("/menu")
	public String irMenuOwner() {
		return "OwnerMenu";
	}

	@RequestMapping("/loginOwner")
	public String irPaginaLoginOwner() {
		return "loginOwner";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("owner", new Owner());
		model.addAttribute("listadistrito", dService.listDistrict());
		return "owner";
	}
	

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Owner objOwner, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listadistrito", dService.listDistrict());
			return "owner";
		} else {
			boolean flag = oService.save(objOwner);
			if (flag) {
				sesionOwner = objOwner;
				dogController.setOwner(sesionOwner);
				sController.setOwner(sesionOwner);
				return "redirect:/owner/bienvenido";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/owner/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar")
	public String modificar(Model model) {
		model.addAttribute("owner", sesionOwner);
		model.addAttribute("listadistrito", dService.listDistrict());
		return "ownerEdit";

	}

	@RequestMapping("/irBuscar")
	public String IrBuscar(Model model) throws ParseException {
		model.addAttribute("owner", new Owner());
		return "buscar";
	}

	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Owner owner) throws ParseException {
		List<Owner> listOwners;
		owner.setFirstNames(owner.getFirstNames());
		listOwners = oService.findByName(owner.getFirstNames());

		if (listOwners.isEmpty()) {
			model.put("mensaje", "No existen coincidencias");
		}

		model.put("listOwners", listOwners);

		return "buscar";
	}


	@RequestMapping("/validarUsuario")
	public String ingresarCuenta(@ModelAttribute Owner objOwner) throws ParseException {
		List<Owner> listOwners;
		objOwner.setEmail(objOwner.getEmail());
		objOwner.setPassword(objOwner.getPassword());
		listOwners = oService.findByEmailAndPassword(objOwner.getEmail(), objOwner.getPassword());

		if (!listOwners.isEmpty()) {
			objOwner = listOwners.get(0);
			System.out.print(objOwner.getEmail());
			System.out.print(objOwner.getFirstNames());
			dogController.setOwner(sesionOwner);
			sesionOwner = objOwner;
			return "redirect:/owner/bienvenido";
		}
		else 
			return "ownerLogin";
	}

}
