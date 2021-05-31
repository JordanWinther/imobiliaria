package curso.projetoiur.projetoiur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EntityScan("curso.projetoiur.model")
@ComponentScan(basePackages = {"curso.projetoiur*"})
@EnableJpaRepositories("curso.projetoiur.repository")
@EnableTransactionManagement
public class ProjetoiurApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoiurApplication.class, args);
	}

}
