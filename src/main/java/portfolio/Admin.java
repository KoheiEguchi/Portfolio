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
	
	//管理用ページを開く
	@GetMapping("/admin")
	public String adminOpen() {
		return "admin";
	}
	
	//管理人かをログインで確認する
	@PostMapping("/admin")
	public String admin(@RequestParam("loginId") String loginId, @RequestParam("password") String password, Model model) {
		//入力内容が正しい場合
		if(loginId.equals("admin") && password.equals("password")) {
			List<Form> formList = formRep.getForm();
			model.addAttribute("formList", formList);
			
			model.addAttribute("isAdmin", true);
		//正しくない場合
		}else {
			model.addAttribute("noAdmin", true);
		}
		return "admin";
	}
	
	//連絡を削除する
	@PostMapping("/formDelete")
	public String formDelete(@RequestParam("formId") int formId, Model model) {
		formRep.formDelete(formId);
		model.addAttribute("delete", true);
		
		//連絡一覧をもう一度開く
		admin("admin", "password", model);
		return "admin";
	}
}
