package seniorlabs.challenge.softwareengineer.hcm.contrroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import seniorlabs.challenge.softwareengineer.hcm.contrroller.responses.Response;
import seniorlabs.challenge.softwareengineer.hcm.model.documents.PontosMarcados;
import seniorlabs.challenge.softwareengineer.hcm.model.utils.MarcacaoPontoUtil;
import seniorlabs.challenge.softwareengineer.hcm.model.utils.MarcacaoUtil;
import seniorlabs.challenge.softwareengineer.hcm.service.PontosMarcadosService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe de 'controller' (controle), para a collection MarcacaoPonto.
 *
 * @author Jonathas Rocha
 */
@RestController
@RequestMapping(path = "/api/marcacaoponto")
public class PontosMarcadosController {

    @Autowired
    private PontosMarcadosService pontosMarcadosService;
    @Autowired
    private MarcacaoUtil marcacaoPontoUtil;

    @GetMapping
    public ResponseEntity<Response<List<PontosMarcados>>> listarTodos() {
        return ResponseEntity.ok(new Response<>(this.pontosMarcadosService.listarTodos()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response<Optional<PontosMarcados>>> listarPorId(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(new Response<>(this.pontosMarcadosService.listarPorId(id)));
    }

    @PostMapping
    public ResponseEntity<Response<PontosMarcados>> cadastrar(PontosMarcados pontoMarcado, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> errors.add(erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<PontosMarcados>(errors));
        }

        // seta a data e hora exata da marcação de ponto
        pontoMarcado.setData(marcacaoPontoUtil.buscaDataHoraMarcacao().toString());
        // Gera valor randômico para o id do colaborador
        String colaboradorID = String.valueOf(marcacaoPontoUtil.geraIdentificador());
        pontoMarcado.setColaboradorID(colaboradorID);
        // Gera valor randômico para o id da empresa
        String empresaID = String.valueOf(marcacaoPontoUtil.geraIdentificador());
        pontoMarcado.setEmpresaID(empresaID);

        return ResponseEntity.ok(new Response<PontosMarcados>(this.pontosMarcadosService.cadastrar(pontoMarcado)));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Response<PontosMarcados>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody PontosMarcados pontoMarcado, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> errors.add(erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<PontosMarcados>(errors));
        }

        pontoMarcado.setId(id);
        return ResponseEntity.ok(new Response<PontosMarcados>(this.pontosMarcadosService.atualizar(pontoMarcado)));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Response<String>> remover(@PathVariable(name = "id") String id) {
        this.pontosMarcadosService.remover(id);
        return ResponseEntity.ok(new Response<String>("Deletado com sucesso"));
    }

    @DeleteMapping
    public ResponseEntity<Response<String>> removerTodos() {
        this.pontosMarcadosService.removerTodos();
        return ResponseEntity.ok(new Response<String>("Todos deletado com sucesso!"));
    }

}
