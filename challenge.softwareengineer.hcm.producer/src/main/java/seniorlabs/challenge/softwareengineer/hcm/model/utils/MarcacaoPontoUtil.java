package seniorlabs.challenge.softwareengineer.hcm.model.utils;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * Implementação da interface {@link MarcacaoUtil}.
 * Responsavel pelas marcações de ponto.
 *
 * @author Jonathas Rocha
 */
@Service
public class MarcacaoPontoUtil implements MarcacaoUtil {

    /**
     * {@inheritDoc}
     */
    @Override
    public int geraIdentificador() {
        Random random = new Random();
        int randomNum =  random.nextInt(10000); // 10.000

        return randomNum;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date buscaDataHoraMarcacao() {
        return new Date(System.currentTimeMillis());
    }

}
