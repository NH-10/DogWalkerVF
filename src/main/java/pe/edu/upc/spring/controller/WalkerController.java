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

import pe.edu.upc.spring.model.District;
import pe.edu.upc.spring.model.Owner;
import pe.edu.upc.spring.model.Walker;
import pe.edu.upc.spring.service.IDistrictService;
import pe.edu.upc.spring.service.IFeedbackService;
import pe.edu.upc.spring.service.IPersonalityService;
import pe.edu.upc.spring.service.IWalkerService;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

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

	@Autowired
	private FeedbackController feedbackController;

	@Autowired
	private IFeedbackService fService;

	@Autowired
	private WalkerController w;

	private Walker sesionWalker;
	private Owner sesionOwner;

	@RequestMapping("/inicio")
	public String irPaginaInicio(Model model) {
		model.addAttribute("district", new District());
		return "bienvenido2";
	}

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida(Model model) {
		model.addAttribute("walker", sesionWalker);
		model.addAttribute("district", new District());
		return "bienvenidoWalker";
	}

	@RequestMapping("/consejos")
	public String irConsejos(Model model) {
		model.addAttribute("walker", sesionWalker);
		return "Consejos";
	}

	@RequestMapping("/noticias")
	public String irNoticias(Model model) {
		model.addAttribute("walker", sesionWalker);
		return "Noticias2";
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
			sController.setWalker(sesionWalker);
			return "redirect:/walker/bienvenido";
		} else
			return "walkerLogin";
	}

	@RequestMapping("/buscar")
	public String buscarPorDistrito(Map<String, Object> model, @ModelAttribute District district)
			throws ParseException {
		List<Walker> listaDistrict;
		listaDistrict = wService.listByDistrict(district.getName());
		feedbackController.setDistrict(district);
		sController.setDistrict(district);
		model.put("owner", sesionOwner);
		model.put("WalkerController", w);

		if (listaDistrict.isEmpty()) {
			model.put("listarPaseadores", wService.list());
		} else {
			model.put("listarPaseadores", listaDistrict);

		}

		return "walkerListByDistrict";

	}

	public int calcularEdad(Date dateOfBirth) {
		Calendar fechaNac = Calendar.getInstance();
		fechaNac.setTime(dateOfBirth);
		int year = fechaNac.get(Calendar.YEAR);
		int month = fechaNac.get(Calendar.MONTH);
		int day = fechaNac.get(Calendar.DAY_OF_MONTH);
		LocalDate fechaHoy = LocalDate.now();
		LocalDate fechaNacimiento = LocalDate.of(year, month, day);
		Period periodo = Period.between(fechaNacimiento, fechaHoy);
		return periodo.getYears();
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model, @ModelAttribute District district) {
		model.put("listarPaseadores", wService.list());
		return "walkerListByDistrict";
	}

	@RequestMapping("/Comentarios")
	public String ListFeedbackByWalker(Model model) {
		model.addAttribute("listaFeedbacks", fService.FeedbackByIdWalker(String.valueOf(sesionWalker.getIdWalker())));
		model.addAttribute("walker", sesionWalker);
		return "FeedbackByWalkers";
	}

	public void setSesionOwner(Owner sesionOwner) {
		this.sesionOwner = sesionOwner;
	}

}
