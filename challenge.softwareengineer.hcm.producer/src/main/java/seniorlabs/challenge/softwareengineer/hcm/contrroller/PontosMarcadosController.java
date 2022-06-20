package seniorlabs.challenge.softwareengineer.hcm.contrroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import seniorlabs.challenge.softwareengineer.hcm.contrroller.responses.Response;
import seniorlabs.challenge.softwareengineer.hcm.events.ProdutorEvento;
import seniorlabs.challenge.softwareengineer.hcm.events.service.ProdutorService;
import seniorlabs.challenge.softwareengineer.hcm.model.documents.PontosMarcados;
import seniorlabs.challenge.softwareengineer.hcm.model.utils.MarcacaoUtil;
import seniorlabs.challenge.softwareengineer.hcm.service.PontosMarcadosService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Classe de 'controller' (controle), para a collection MarcacaoPonto.
 *
 * @author Jonathas Rocha
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping(path = "/api/marcacaoponto")
public class PontosMarcadosController {

    @Autowired
    private PontosMarcadosService pontosMarcadosService;
    @Autowired
    private MarcacaoUtil marcacaoPontoUtil;
    @Autowired
    private ProdutorService produtorUtil;

    /**
     * Lista todas as marcações de ponto.
     *
     * @return {@link ResponseEntity}
     */
    @GetMapping
    public ResponseEntity<Response<List<PontosMarcados>>> listarTodos() {
        return ResponseEntity.ok(new Response<>(this.pontosMarcadosService.listarTodos()));
    }

    /**
     * Lista uma marcação de ponto por ID.
     *
     * @param id
     * @return {@link ResponseEntity}
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Response<Optional<PontosMarcados>>> listarPorId(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(new Response<>(this.pontosMarcadosService.listarPorId(id)));
    }

    /**
     * Executa quando o usuário chamar a api, para marcar um ponto.
     *
     * @param pontoMarcado
     * @param result
     * @return {@link ResponseEntity}
     */
    @PostMapping
    public ResponseEntity<Response<PontosMarcados>> cadastrar(PontosMarcados pontoMarcado, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> errors.add(erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<PontosMarcados>(errors));
        }

        // seta a data e hora exata da marcação de ponto
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String dataString = sdf.format(marcacaoPontoUtil.buscaDataHoraMarcacao());
        pontoMarcado.setData(dataString);
        // Gera valor randômico para o id do colaborador
        String colaboradorID = String.valueOf(marcacaoPontoUtil.geraIdentificador());
        pontoMarcado.setColaboradorID(colaboradorID);
        // Gera valor randômico para o id da empresa
        String empresaID = String.valueOf(marcacaoPontoUtil.geraIdentificador());
        pontoMarcado.setEmpresaID(empresaID);

        // Inicia a producer, após marcar o ponto
        produtorUtil.iniciarProducer(dataString, colaboradorID, empresaID);

        return ResponseEntity.ok(new Response<PontosMarcados>(this.pontosMarcadosService.cadastrar(pontoMarcado)));
    }

    /**
     * Atualiza uma marcação de pontoo no MongoDB.
     *
     * @param id
     * @param pontoMarcado
     * @param result
     * @return {@link ResponseEntity}
     */
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

    /**
     * Deleta uma marcação de ponto do mongoDb.
     *
     * @param id
     * @return {@link ResponseEntity}
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Response<String>> remover(@PathVariable(name = "id") String id) {
        this.pontosMarcadosService.remover(id);
        return ResponseEntity.ok(new Response<String>("Deletado com sucesso"));
    }

    /**
     * Deleta todas as marcações de ponto do mongoDb.
     *
     * @return {@link ResponseEntity}
     */
    @DeleteMapping
    public ResponseEntity<Response<String>> removerTodos() {
        this.pontosMarcadosService.removerTodos();
        return ResponseEntity.ok(new Response<String>("Todos deletado com sucesso!"));
    }

}
