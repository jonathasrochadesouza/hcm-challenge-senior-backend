package seniorlabs.challenge.softwareengineer.hcm.contrroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe Controller que retorna o status, se foi possível se conectar.
 *
 * @author Jonathas Rocha
 */
@RestController
public class StatusController {

    /**
     * Método GET. Checa conexão, retornando 'online'
     *
     * @return a {@link String}, if connected
     */
    @GetMapping(path = "/api/status")
    public String check() {
        return "online";
    }

}
