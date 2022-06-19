package seniorlabs.challenge.softwareengineer.hcm.model.utils;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MarcacaoPontoUtilTest {

    MarcacaoPontoUtil marcacao = new MarcacaoPontoUtil();

    @Test
    void geraIdentificadorEntreMinimoMaximo() {
        int min = 0, max = 10000;
        boolean valorValido = true;

        if(marcacao.geraIdentificador() < min || marcacao.geraIdentificador() > max){
            valorValido = false;
        }

        assertTrue(valorValido);
    }

    @Test
    void geraIdentificadorNotNull() {
        assertNotNull(marcacao.geraIdentificador());
    }

//    @Test
//    void buscaDataHoraMarcacao() {
//        assertEquals(String.format("yyy"), String.format("yyy"));
//    }

    @Test
    void geraDataHoraNotNull() {
        Date data = marcacao.buscaDataHoraMarcacao();

        assertNotNull(data);
    }
}