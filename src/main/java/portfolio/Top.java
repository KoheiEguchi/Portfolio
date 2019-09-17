package portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Top {
	@Autowired
	FormRepository formRep;
	
	@GetMapping({"/", "top"})
	public String topOpen() {
		return "top";
	}
	
	@PostMapping("/form")
	public String form(@ModelAttribute Form form, Model model) {
		boolean formCheck = true;
		if(form.getName().equals("")) {
			model.addAttribute("nameCheck", true);
			formCheck = false;
		}
		if(form.getAddress().equals("")) {
			model.addAttribute("addressCheck", true);
			formCheck = false;
		}
		if(form.getContent().equals("")) {
			model.addAttribute("contentCheck", true);
			formCheck = false;
		}
		
		if(formCheck == true) {
			formRep.newForm(form.getName(), form.getAddress(), form.getContent());
			model.addAttribute("msg", "送信しました。");
		}
		return "top";
	}
}
