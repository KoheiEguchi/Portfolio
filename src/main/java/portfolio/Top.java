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
	
	//トップページを開く
	@GetMapping({"/", "top"})
	public String topOpen() {
		return "top";
	}
	
	//連絡を送信する
	@PostMapping("/form")
	public String form(@ModelAttribute Form form, Model model) {
		boolean formCheck = true;
		
		//名前が空欄の場合
		if(form.getName().equals("")) {
			model.addAttribute("nameCheck", true);
			formCheck = false;
		}
		//連絡先が空欄の場合
		if(form.getAddress().equals("")) {
			model.addAttribute("addressCheck", true);
			formCheck = false;
		}
		//内容が空欄の場合
		if(form.getContent().equals("")) {
			model.addAttribute("contentCheck", true);
			formCheck = false;
		}
		
		//全て入力できている場合
		if(formCheck == true) {
			formRep.newForm(form.getName(), form.getAddress(), form.getContent());
			model.addAttribute("send", true);
		}
		
		//連絡欄を表示する
		model.addAttribute("formOpen", true);
		
		return "top";
	}
}
