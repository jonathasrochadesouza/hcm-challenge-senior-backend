package seniorlabs.challenge.softwareengineer.hcm.model.documents;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Classe referente a 'collection' PontosMarcados, no banco não relacional (NoSQL), MongoDB.
 * Responsável pelos dados que devem ser encaminhados para o sistema legado.
 *
 * @author Jonathas Rocha
 */
@Document
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PontosMarcados {

    @Id
    private String id;
    private String data;
    private String colaboradorID;
    private String empresaID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getColaboradorID() {
        return colaboradorID;
    }

    public void setColaboradorID(String colaboradorID) {
        this.colaboradorID = colaboradorID;
    }

    public String getEmpresaID() {
        return empresaID;
    }

    public void setEmpresaID(String empresaID) {
        this.empresaID = empresaID;
    }

}
