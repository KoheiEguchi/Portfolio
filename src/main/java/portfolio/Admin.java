package portfolio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Admin {
	@Autowired
	FormRepository formRep;
	
	@GetMapping("/admin")
	public String adminOpen() {
		return "admin";
	}
	
	@PostMapping("/admin")
	public String admin(@RequestParam("loginId") String loginId, @RequestParam("password") String password, Model model) {
		if(loginId.equals("admin") && password.equals("password")) {
			List<Form> formList = formRep.getForm();
			model.addAttribute("formList", formList);
			
			model.addAttribute("isAdmin", true);
		}else {
			model.addAttribute("msg", true);
		}
		return "admin";
	}
}
