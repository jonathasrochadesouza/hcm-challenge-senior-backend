package seniorlabs.challenge.softwareengineer.hcm.model.utils;

import java.util.Date;

/**
 * Interface para as marcações de ponto
 *
 * @author Jonathas Rocha
 */
public interface MarcacaoUtil {

//    void marcarPonto();

//    void marcarVariosPontos(int qtd);

    /**
     * Simula um identificador, gerando um número aleatório/randômico de inteiro.
     *
     * @return um valor inteiro, simulando um identificador
     */
    int geraIdentificador();

    /**
     * Busca o momento exato em que a marcação de ponto ocorreu.
     *
     * @return um {@link Date}
     */
    Date buscaDataHoraMarcacao();

}
