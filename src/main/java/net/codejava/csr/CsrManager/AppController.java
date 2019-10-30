package net.codejava.csr.CsrManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private CsrService service;
	
	@RequestMapping("/")
	public String ViewHomePage(Model model) {
		List<Csr> listCsrs = service.listAll();
		model.addAttribute("listCsrs", listCsrs);
		return "index";
	}
	
	@RequestMapping("/new")
	public String FormNewPlan(Model model) {
		
		Csr csr = new Csr();
		model.addAttribute("csr", csr);
		
		return "new_plan";
		}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCsr(@ModelAttribute("csr")Csr csr ) {
		service.save(csr);
		return "redirect:/";
		}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCsrForm(@PathVariable(name = "id")Long id) {
		ModelAndView mav = new ModelAndView("form_edit");
		Csr csr = service.get(id);
		mav.addObject("csr", csr);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deletePlan(@PathVariable(name = "id")Long id) {
	service.delete(id);
	return "redirect:/";
	}
	
	
}
