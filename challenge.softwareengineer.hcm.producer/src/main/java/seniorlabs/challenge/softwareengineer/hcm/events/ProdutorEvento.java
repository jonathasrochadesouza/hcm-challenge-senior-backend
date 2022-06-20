package seniorlabs.challenge.softwareengineer.hcm.events;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

/**
 * Realiza a produção dos eventos
 *
 * @author Jonathas Rocha
 */
@Slf4j
public class ProdutorEvento {

    private final Producer<String, String> producer;

    public ProdutorEvento() {
        producer = criarProducer();
    }

    private Producer<String, String> criarProducer() {
        if (producer != null) {
            return producer;
        }

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("serializer.class", "kafka.serializer.DefaultEncoder");
        return new KafkaProducer<String, String>(properties);
    }

    public void executar(String data, String colaboradorId, String empresaId) {
        String chave = UUID.randomUUID().toString();

        String mensagem = "Data do registro do ponto: " + data + ", "
                + "Identificador do colaborador: " + colaboradorId + ", "
                + "Identificador da empresa: " + empresaId;

        mensagem += " | CHAVE: " + chave;

        log.info("Iniciando envio da mensagem");

        ProducerRecord<String, String> record = new ProducerRecord<String, String>("RegistroEvento", chave, mensagem);
        producer.send(record);
        producer.flush();
        producer.close();

        log.info("Mensagem enviada com sucesso [{}]", mensagem);
    }

}
