package curso.projetoiur.controler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.projetoiur.model.Imovel;
import curso.projetoiur.repository.RepositoryImovel;

@Controller
public class ControlerPesquisa {

	
	@Autowired
	private RepositoryImovel repositoryImovel;
	
	
	  
	//MÉTODO DE PESQUISA, RETORNA PARA CADASTRO DE IMOVEIS
	
		@PostMapping("**/pesquisar")
		public ModelAndView pesquisar(@RequestParam("search") String search) {
			ModelAndView andView = new ModelAndView("cadastro/cadastroImoveis");
			andView.addObject("imoveis", repositoryImovel.findByTipo(search));
			andView.addObject("ImovelObjeto", new Imovel());
			return andView;
		}

}
