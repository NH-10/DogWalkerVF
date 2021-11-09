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

import pe.edu.upc.spring.model.District;
import pe.edu.upc.spring.model.Dog;
import pe.edu.upc.spring.model.Feedback;
import pe.edu.upc.spring.model.Owner;
import pe.edu.upc.spring.model.ServiceRequest;
import pe.edu.upc.spring.model.Walker;
import pe.edu.upc.spring.service.IDistrictService;
import pe.edu.upc.spring.service.IDogService;
import pe.edu.upc.spring.service.IFeedbackService;
import pe.edu.upc.spring.service.IOwnerService;
import pe.edu.upc.spring.service.IRaceService;
import pe.edu.upc.spring.service.IServiceRequestService;
import pe.edu.upc.spring.service.IWalkerService;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {


	@Autowired
	private IWalkerService wService;

	@Autowired
	private IFeedbackService fService;

	@Autowired
	private WalkerController w;
	
	private Owner sesionOwner;
	private Walker sesionWalker;
	private District district;

	@RequestMapping("/ListaPaseadores")
	public String irListaPaseadores(Map<String, Object> model) {
		List<Walker> listaDistrict;
		listaDistrict = wService.listByDistrict(district.getName());
		
		model.put("WalkerController", w);	
		
		if(listaDistrict.isEmpty()) {
			model.put("listarPaseadores", wService.list());
		}	
		else {
		model.put("listarPaseadores", listaDistrict);
		}
		return "walkerListByDistrict"; 
	}
	
	
	
	@RequestMapping("/Comentarios")
	public String modificar(Model model, @RequestParam(value="id") Integer id) throws ParseException{
		sesionWalker = wService.WalkerById(String.valueOf(id));
		if(sesionWalker == null) {
			model.addAttribute("walker", sesionWalker);
			model.addAttribute("owner",sesionOwner);
			return "redirect:/feedback/ListaPaseadores";
		}
		else {
			model.addAttribute("listaFeedbacks",fService.FeedbackByIdWalker(String.valueOf(sesionWalker.getIdWalker())));
			model.addAttribute("Feedback",new Feedback());
			return "listFeedbacks";
		}
	}
	
	@RequestMapping("/ActualizarComentarios")
	public String modificar(Model model) throws ParseException{
			model.addAttribute("listaFeedbacks",fService.FeedbackByIdWalker(String.valueOf(sesionWalker.getIdWalker())));
			model.addAttribute("Feedback",new Feedback());
			return "listFeedbacks";
	}
	
	@RequestMapping("/Crear")
	public String registrar(@ModelAttribute Feedback objFeedback, BindingResult binRes, Model model) throws ParseException{
		if (binRes.hasErrors()) {
			model.addAttribute("walker", sesionWalker);
			model.addAttribute("owner",sesionOwner);
			return "listFeeedbacks";
		} else {
			objFeedback.setOwner(sesionOwner);
			objFeedback.setWalker(sesionWalker);
			boolean flag = fService.save(objFeedback);
			if (flag) {
				return "redirect:/feedback/ActualizarComentarios";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/feedback/ActualizarComentarios";
			}
		}
	}
	

	public void setDistrict(District district) {
		this.district = district;
	}
	public void setOwner(Owner o) {
		this.sesionOwner = o;
	}
	
}
