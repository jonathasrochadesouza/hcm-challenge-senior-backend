package seniorlabs.challenge.softwareengineer.hcm.service;

import seniorlabs.challenge.softwareengineer.hcm.model.documents.PontosMarcados;

import java.util.List;
import java.util.Optional;

/**
 * Contém as assinaturas dos métodos para a API de marcação de ponto
 *
 * @author Jonathas Rocha
 */
public interface PontosMarcadosService {

    /**
     * Retorna todas as marcações
     *
     * @return {@link List} de {@link PontosMarcados}
     */
    List<PontosMarcados> listarTodos();

    /**
     * Retorna uma marcação
     *
     * @param id
     * @return um {@link PontosMarcados}
     */
    Optional<PontosMarcados> listarPorId(String id);

    /**
     * Cadastra uma nova marcação
     *
     * @param pontoMarcado
     * @return o {@link PontosMarcados}, cadastrado
     */
    PontosMarcados cadastrar(PontosMarcados pontoMarcado);

    /**
     * Atualiza uma marcação
     *
     * @param pontoMarcado
     * @return um {@link PontosMarcados}
     */
    PontosMarcados atualizar(PontosMarcados pontoMarcado);

    /**
     * Remove uma marcação
     *
     * @param id
     */
    void remover(String id);

    /**
     * Remove todas as marcações
     */
    void removerTodos();

}
