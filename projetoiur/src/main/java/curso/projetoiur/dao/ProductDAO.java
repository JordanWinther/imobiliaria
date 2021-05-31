package curso.projetoiur.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import curso.projetoiur.model.Livro;

@Repository
public class ProductDAO {
	@PersistenceContext
	private EntityManager manager;
	
	public void save( Livro livro) {
		manager.persist(livro);
	}
}
