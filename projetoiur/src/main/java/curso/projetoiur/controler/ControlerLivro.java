package curso.projetoiur.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import curso.projetoiur.dao.ProductDAO;
import curso.projetoiur.model.Livro;

@Controller
public class ControlerLivro {

	@Autowired
	private ProductDAO productDAO;
	
	@PostMapping("/cadastro/livro")
	public String SalvarLivro(Livro livro) {
		productDAO.save(livro);
		System.out.println("Cadastrando o produto "+livro);
		return "livro/ok";
	}
}
