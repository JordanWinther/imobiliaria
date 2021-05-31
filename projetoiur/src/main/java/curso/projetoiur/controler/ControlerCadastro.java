package curso.projetoiur.controler;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.projetoiur.model.Imovel;
import curso.projetoiur.model.Pessoa;
import curso.projetoiur.repository.RepositoryImovel;
import curso.projetoiur.repository.RepositoryPessoa;
import javassist.expr.NewArray;

@Controller
public class ControlerCadastro {

	@Autowired
	private RepositoryPessoa repositoryPessoa;
	
	@Autowired
	private RepositoryImovel repositoryImovel;
	
	// MÉTODO DIRECIONAMENTO PARA CADASTRO PESSOA
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastroPessoa")
	public String Cadastro() {
		return "cadastro/cadastroPessoa";
	}
	
	// MÉTODO DIRECIONAMENTO PARA HOME PRODUTOS
	
	@GetMapping(value = "/homeProdutos")
	public ModelAndView homeProdutos() {
		
	ModelAndView andView = new ModelAndView("cadastro/homeProdutos");
		Iterable<Imovel> iterable = repositoryImovel.findAll();
		andView.addObject("imoveis", iterable);
		andView.addObject("ImovelObjeto", new Imovel());
			
		return andView;
	}
	
	// MÉTODO SALVAR PESSOA
	
	@RequestMapping(method = RequestMethod.POST, value = "/salvarPessoa")
	public String Salvar(Pessoa pessoa) {
		repositoryPessoa.save(pessoa);
		
		return "cadastro/cadastroPessoa";
	}
	
	// MÉTODO DIRECIONAMENTO PARA CADATRO DE IMÓVEIS
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastraImovel")
	public ModelAndView CadastraImoveil() {
		ModelAndView andView = new ModelAndView("cadastro/cadastroImoveis");
		andView.addObject("ImovelObjeto", new Imovel());
		return andView;
	}
	
	// MÉTODO SALVAR IMÓVEL
	
	@RequestMapping(method = RequestMethod.POST, value = "**/salvarImovel")
	public ModelAndView SalvarImovel(Imovel imovel) {
		repositoryImovel.save(imovel);
		ModelAndView andView = new ModelAndView("cadastro/cadastroImoveis");
		andView.addObject("ImovelObjeto",  new Imovel()); //Envia um objeto de imovel em branco para o form.
		return andView;
	}
	
	// MÉTODO SALVAR IMÓVEL 2
	
	@PostMapping( value="/salvarImovel2")
	public ModelAndView SalvarImovel2(Imovel imovel ) {
		ModelAndView andView = new ModelAndView("cadastro/homeProdutos");
		repositoryImovel.save(imovel);
		andView.addObject("ImovelObjeto", new Imovel());
		return andView;
		
	}
	
	
	
	//MÉTODO MONTA UM VIEW COM UM OBJETO CONTENDO TODOS REGISTROS DA TABELA IMOVEIS
	
	@RequestMapping(method = RequestMethod.GET, value = "/listarImoveis")
	public ModelAndView listarImoveis() {
	ModelAndView andView = new ModelAndView("cadastro/cadastroImoveis");
	Iterable<Imovel> iterableImovel = repositoryImovel.findAll();
	andView.addObject("imoveis", iterableImovel);
	andView.addObject("ImovelObjeto",  new Imovel()); 
	return andView;
	}
	
	
	@GetMapping("**/editarImovel/{idImovel}")
	public ModelAndView editarImovel(@PathVariable("idImovel") Long idImovel) {
		ModelAndView andView = new ModelAndView("cadastro/cadastroImoveis");
		
		Optional<Imovel> imovel = repositoryImovel.findById(idImovel);
		
		andView.addObject("ImovelObjeto", imovel);
		return andView;
	}
	
@GetMapping("**/excluirImovel/{idImovel}")	
public ModelAndView excluirImovel(@PathVariable("idImovel") Long idmovel) {
	ModelAndView andView = new ModelAndView("cadastro/cadastroImoveis");
	   
	repositoryImovel.deleteById(idmovel);
	Iterable<Imovel> iterableImovel = repositoryImovel.findAll();
	andView.addObject("imoveis", iterableImovel);
	andView.addObject("ImovelObjeto",  new Imovel()); 
	return andView;
	
}

	



}

