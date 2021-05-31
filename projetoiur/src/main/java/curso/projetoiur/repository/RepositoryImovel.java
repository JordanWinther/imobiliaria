package curso.projetoiur.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.projetoiur.model.Imovel;

@Repository
@Transactional
public interface RepositoryImovel extends CrudRepository<Imovel, Long>{
	
	@Query("select i from Imovel i where i.tipo like %?1")
	List<Imovel> findByTipo(String search);
			
		
	

		
}
