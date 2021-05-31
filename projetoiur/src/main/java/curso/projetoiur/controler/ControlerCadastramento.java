package curso.projetoiur.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import curso.projetoiur.model.Pessoa2;
import curso.projetoiur.repository.RepositoryPessoa;

@Controller
public class ControlerCadastramento {

	@Autowired
	private RepositoryPessoa repositoryPessoa;
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastroPessoa2")
	public String CadastroPessoa(){
	return "cadastro/cadastroPessoa";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/salvarPessoa2")
	public ModelAndView salvarPessoa(Pessoa2 pessoa2) {
		repositoryPessoa.save(pessoa2);
		ModelAndView andView = new ModelAndView("cadastro/cadastroPessoa");
		return andView;
		
	}
	
}
