package seniorlabs.challenge.softwareengineer.hcm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import seniorlabs.challenge.softwareengineer.hcm.producer.events.ProdutorEvento;

/**
 * Aplicação, classe que permite rodar a aplicação
 *
 * @author Jonathas Rocha
 */
@Slf4j
@SpringBootApplication
public class ApplicationProducer {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationProducer.class, args);
		ApplicationProducer aplicacao = new ApplicationProducer();
		aplicacao.iniciarProducer();
	}

	private void iniciarProducer() {
		log.info("Iniciando a aplicação");
		ProdutorEvento produtor = new ProdutorEvento();
		produtor.executar();
	}

}
