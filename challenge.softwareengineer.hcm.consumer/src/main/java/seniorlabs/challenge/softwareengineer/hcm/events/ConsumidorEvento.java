package seniorlabs.challenge.softwareengineer.hcm.events;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import seniorlabs.challenge.softwareengineer.hcm.external.SistemaLegado;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Consome os eventos.
 *
 * @author Jonathas Rocha
 */
@Slf4j
public class ConsumidorEvento {

    private final KafkaConsumer<String, String> consumer;

    public ConsumidorEvento() {
        consumer = criarConsumer();
    }

    /**
     * Configuração do Apache Kafka.
     *
     * @return {@link KafkaConsumer}
     */
    private KafkaConsumer<String, String> criarConsumer() {
        if (consumer != null) {
            return consumer;
        }

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "default");

        return new KafkaConsumer<String, String>(properties);
    }

    /**
     * Executa a leitura dos eventos.
     */
    public void executar() {
        List<String> topicos = new ArrayList<>();
        topicos.add("RegistroEvento");
        consumer.subscribe(topicos);

        log.info("Iniciando consumer...");
        boolean continuar = true;
        while (continuar) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<String, String> record : records) {
                gravarMensagem(record.topic(), record.partition(), record.value());

                if (record.value().equals("FECHAR")) {
                    continuar = false;
                }
            }
        }
        consumer.close();
    }

    /**
     * Grava a mensagem e Chama o sistema legado.
     * Aqui seria possível ainda salvar os dados em um banco, retornar outra mensagem...
     *
     * @param topico
     * @param particao
     * @param mensagem
     */
    private void gravarMensagem(String topico, int particao, String mensagem) {
        log.info("Topico:{}, Partição:{}, Mensagem:{}", topico, particao, mensagem);

        ConexaoSistemaLegado();
    }

    /**
     * Faz a conexão com sistema legado.
     * Informa nos logs, qual foi o status code e a mensagem retornada.
     *
     * O Status deve ser 200, já a mensagem deve ser 'Success' (SUCESSO)
     */
    private void ConexaoSistemaLegado() {
        RestTemplate template = new RestTemplate();

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.mockytonk.com")
                .path("proxy/ab2198a3-cafd-49d5-8ace-baac64e72222")
                .build();

        ResponseEntity<SistemaLegado> sistemaLegadoEntity = template.getForEntity(uri.toUriString(), SistemaLegado.class);

        log.info("JONATHAS (CONEXÃO COM O SISTEMA LEGADO) Status Code: " + sistemaLegadoEntity.getStatusCode());
        log.info("JONATHAS (CONEXÃO COM O SISTEMA LEGADO) Mensagem: " + sistemaLegadoEntity.getBody().getMessage());
    }

}
