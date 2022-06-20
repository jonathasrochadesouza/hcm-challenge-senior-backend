package seniorlabs.challenge.softwareengineer.hcm.events.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import seniorlabs.challenge.softwareengineer.hcm.events.ProdutorEvento;
import seniorlabs.challenge.softwareengineer.hcm.events.service.ProdutorService;

/**
 * Implementação de {@link ProdutorService}
 *
 * @author Jonathas Rocha
 */
@Slf4j
@Service
public class ProdutorServiceImpl implements ProdutorService {

    /**
     * {@inheritDoc}
     */
    public void iniciarProducer(String data, String colaboradorId, String empresaId) {
        log.info("JONATHAS_LOG (INICIANDO A APLICAÇÃO)");
        ProdutorEvento produtor = new ProdutorEvento();
        produtor.executar(data, colaboradorId, empresaId);
    }

}
