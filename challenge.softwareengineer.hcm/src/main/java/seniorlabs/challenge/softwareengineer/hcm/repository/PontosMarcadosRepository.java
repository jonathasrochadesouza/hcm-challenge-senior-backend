package seniorlabs.challenge.softwareengineer.hcm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import seniorlabs.challenge.softwareengineer.hcm.model.documents.PontosMarcados;

/**
 * Repository para PontosMarcados.
 *
 * @author Jonathas Rocha
 */
public interface PontosMarcadosRepository extends MongoRepository<PontosMarcados, String> {
}
