package curso.projetoiur.projetoiur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControlerIndex {
	
	@RequestMapping("/")
	public String index() {
		return "home";
	}

}
