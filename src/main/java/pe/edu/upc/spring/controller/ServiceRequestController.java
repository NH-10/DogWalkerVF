package pe.edu.upc.spring.controller;

import java.util.List;
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
import pe.edu.upc.spring.model.ServiceRequest;
import pe.edu.upc.spring.model.Walker;
import pe.edu.upc.spring.service.IOwnerService;
import pe.edu.upc.spring.service.IServiceRequestService;
import pe.edu.upc.spring.service.IStatusService;
import pe.edu.upc.spring.service.ITimeService;
import pe.edu.upc.spring.service.IWalkerService;

@Controller
@RequestMapping("/serviceRequest")
public class ServiceRequestController {
	@Autowired
	private IServiceRequestService srService;

	@Autowired
	private IStatusService sService;

	@Autowired
	private ITimeService tService;

	@Autowired
	private IOwnerService owService;

	@Autowired
	private IWalkerService waService;

	private ServiceRequest sesionServiceRequest;
	
	private Owner sesionOwner;
	
	private Walker sesionWalker;
	
	private String idOwner;
	private String idWalker;
	private List<ServiceRequest> listServiceRequestOwner;
	private List<ServiceRequest> listServiceRequestWalker;

	
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
		model.addAttribute("serviceRequest", new ServiceRequest());
		model.addAttribute("listStatus", sService.listStatus());
		model.addAttribute("listTimes", tService.listTime());
		//model.addAttribute("listOwners", owService.list());
		model.addAttribute("owner", sesionOwner);
		model.addAttribute("listWalker", waService.list());
		
		return "serviceRequest";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute ServiceRequest objServiceRequest, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listStatus", sService.listStatus());
			model.addAttribute("listTimes", tService.listTime());	
			//model.addAttribute("listWalker", waService.list());
			model.addAttribute("owner", sesionOwner);
			return "serviceRequest";
		} else {
			objServiceRequest.setOwner(sesionOwner);
			boolean flag = srService.save(objServiceRequest);
			if (flag) {
				
				sesionServiceRequest = objServiceRequest;
				return "redirect:/owner/menu";
			}
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
			model.addAttribute("listOwners", owService.list());
			model.addAttribute("listWalker", waService.list());
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
	
	
	@RequestMapping("/listarSolicitudesDueno")
	public String listarSolicitudesPorDueno(Model model) 
	{
		idOwner = String.valueOf(sesionOwner.getIdOwner());
		listServiceRequestOwner = srService.listServiceRequestByOwner(idOwner);
		model.addAttribute("listServiceRequestByOwner", listServiceRequestOwner);
		return "serviceRequestListByOwner";
	}	
	
	@RequestMapping("/listarSolicitudesPaseador")
	public String listarSolicitudesPorPaseador(Model model) 
	{
		idWalker = String.valueOf(sesionOwner.getIdOwner());
		listServiceRequestWalker = srService.listServiceRequestByOwner(idWalker);
		model.addAttribute("listServiceRequestByWalker", listServiceRequestWalker);
		return "serviceRequestListByWalker";
	}
	
	
	public void setOwner(Owner o) {
		sesionOwner = o;
	}
	
	public void setWalker(Walker w) {
		sesionWalker = w;
	}

}
