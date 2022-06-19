package seniorlabs.challenge.softwareengineer.hcm.producer;

import lombok.extern.slf4j.Slf4j;
import seniorlabs.challenge.softwareengineer.hcm.producer.events.ProdutorEvento;

/**
 * Executa os producers do evento
 *
 * @author Jonathas Rocha
 */
@Slf4j
public class AplicacaoProducer {

    public static void main(String[] args) {
        AplicacaoProducer aplicacao = new AplicacaoProducer();
        aplicacao.iniciar();
    }

    private void iniciar() {
        log.info("Iniciando a aplicação");
        ProdutorEvento produtor = new ProdutorEvento();
        produtor.executar();
    }

}
