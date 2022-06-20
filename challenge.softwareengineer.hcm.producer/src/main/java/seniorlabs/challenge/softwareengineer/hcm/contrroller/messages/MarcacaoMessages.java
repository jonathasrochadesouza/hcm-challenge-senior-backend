package seniorlabs.challenge.softwareengineer.hcm.contrroller.messages;

import java.util.Date;

public class MarcacaoMessages {

    public String mensagemSucessoMarcacao(Date dataMarcacao) {
        return String.format("Marcação de ponto realizada com sucesso em %s", /*(in utils) create a convertFormatString(*/dataMarcacao);
    }

}
