package pe.edu.upc.spring.controller;

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
import pe.edu.upc.spring.model.ServiceRequest;
import pe.edu.upc.spring.model.Status;
import pe.edu.upc.spring.model.Time;
import pe.edu.upc.spring.model.Walker;
import pe.edu.upc.spring.service.IServiceRequestService;
import pe.edu.upc.spring.service.IStatusService;
import pe.edu.upc.spring.service.ITimeService;

@Controller
@RequestMapping("/serviceRequest")
public class ServiceRequestController {
	@Autowired
	private IServiceRequestService srService;

	@Autowired
	private IStatusService sService;

	@Autowired
	private ITimeService tService;

	// @Autowired
	// private IOwnerService owService;

	// @Autowired
	// private IWalkerService waService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irPaginaListadoRazas(Map<String, Object> model) {
		model.put("listServiceRequests", srService.listServiceRequest());
		return "listServiceRequest";
	}

	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {

		model.addAttribute("listStatus", sService.listStatus());
		model.addAttribute("listTimes", tService.listTime());
		// model.addAttribute("listOwners", owService.listOwner());
		// model.addAttribute("listWalker", waService.listWalker());

		model.addAttribute("serviceRequest", new ServiceRequest());
		model.addAttribute("status", new Status());
		model.addAttribute("time", new Time());
		model.addAttribute("owner", new Owner());
		model.addAttribute("walker", new Walker());

		return "serviceRequest";
	}

	@RequestMapping("/registrar")
	public String save(@ModelAttribute ServiceRequest objServiceRequest, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listStatus", sService.listStatus());
			model.addAttribute("listTimes", tService.listTime());
			// model.addAttribute("listOwners", owService.listOwner());
			// model.addAttribute("listWalker", waService.listWalker());
			return "serviceRequest";
		} else {
			boolean flag = srService.save(objServiceRequest);
			if (flag)
				return "redirect:/serviceRequest/listar";
			else {
				model.addAttribute("mensaje", "Error al guadra solicitud");
				return "redirect:/serviceRequest/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<ServiceRequest> objServiceRequest = srService.listId(id);
		if (objServiceRequest == null) {
			objRedir.addFlashAttribute("mensaje", "Error al modificar Solicitud");
			return "redirect:/serviceRequest/listar";
		} else {
			model.addAttribute("listStatus", sService.listStatus());
			model.addAttribute("listTimes", tService.listTime());
			// model.addAttribute("listOwners", owService.listOwner());
			// model.addAttribute("listWalker", waService.listWalker());
			if (objServiceRequest.isPresent())
				objServiceRequest.ifPresent(o -> model.addAttribute("serviceRequest", o));

			return "serviceRequest";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				srService.delete(id);
				model.put("listServiceRequests", srService.listServiceRequest());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listServiceRequests", srService.listServiceRequest());
		}
		return "listServiceRequest";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listServiceRequests", srService.listServiceRequest());
		return "listServiceRequest";
	}

	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute ServiceRequest serviceRequest)
			throws ParseException {
		srService.listId(serviceRequest.getIdServiceRequest());
		return "listServiceRequest";
	}

}
