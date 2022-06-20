package seniorlabs.challenge.softwareengineer.hcm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import seniorlabs.challenge.softwareengineer.hcm.events.ProdutorEvento;

/**
 * Permite executar a aplicação Producer
 *
 * @author Jonathas Rocha
 */
@Slf4j
@SpringBootApplication
public class AplicacaoProducer {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoProducer.class, args);
	}

}
