package seniorlabs.challenge.softwareengineer.hcm.events.service;

/**
 * Serviço responsável pelo Producer (Produtor), de eventos
 *
 * @author Jonathas Rocha
 */
public interface ProdutorService {

    /**
     * Inicia o producer
     */
    void iniciarProducer(String data, String colaboradorId, String empresaId);

}
