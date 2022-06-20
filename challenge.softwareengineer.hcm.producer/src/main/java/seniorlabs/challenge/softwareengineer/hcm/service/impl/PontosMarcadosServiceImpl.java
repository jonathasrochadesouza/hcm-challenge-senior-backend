package seniorlabs.challenge.softwareengineer.hcm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seniorlabs.challenge.softwareengineer.hcm.model.documents.PontosMarcados;
import seniorlabs.challenge.softwareengineer.hcm.repository.PontosMarcadosRepository;
import seniorlabs.challenge.softwareengineer.hcm.service.PontosMarcadosService;

import java.util.List;
import java.util.Optional;

/**
 * Implementação de PontosMarcadosService
 *
 * @author Jonathas Rocha
 */
@Service
public class PontosMarcadosServiceImpl implements PontosMarcadosService {

    @Autowired
    private PontosMarcadosRepository pontosMarcadosRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PontosMarcados> listarTodos() {
        return this.pontosMarcadosRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<PontosMarcados> listarPorId(String id) {
        return this.pontosMarcadosRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PontosMarcados cadastrar(PontosMarcados pontoMarcado) {
        return this.pontosMarcadosRepository.save(pontoMarcado);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PontosMarcados atualizar(PontosMarcados pontoMarcado) {
        return this.pontosMarcadosRepository.save(pontoMarcado);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remover(String id) {
        this.pontosMarcadosRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removerTodos() {
        this.pontosMarcadosRepository.deleteAll();
    }

}
