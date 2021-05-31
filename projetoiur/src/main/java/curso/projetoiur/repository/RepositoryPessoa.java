package curso.projetoiur.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.projetoiur.model.Pessoa;
import curso.projetoiur.model.Pessoa2;

@Repository
@Transactional
public interface RepositoryPessoa extends CrudRepository<Pessoa, Long> {

	void save(Pessoa2 pessoa2);

}
