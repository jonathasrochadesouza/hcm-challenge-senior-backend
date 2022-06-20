package seniorlabs.challenge.softwareengineer.hcm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import seniorlabs.challenge.softwareengineer.hcm.events.ConsumidorEvento;

/**
 * Permite executar a aplicação Consumer
 *
 * @author Jonathas Rocha
 */
@Slf4j
@SpringBootApplication
public class AplicacaoConsumer {

	public static void main(String[] args) {
		AplicacaoConsumer aplicacao = new AplicacaoConsumer();
		aplicacao.iniciar();
	}

	private void iniciar() {
		log.info("Iniciando a aplicação");
		ConsumidorEvento consumidor = new ConsumidorEvento();
		consumidor.executar();
	}

}
