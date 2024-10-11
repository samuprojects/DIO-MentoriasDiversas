package dio.expertostech.tutorial.microservico.kafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dio.expertostech.tutorial.microservico.kafka.data.PedidoData;
import dio.expertostech.tutorial.microservico.kafka.entity.Pedido;
import dio.expertostech.tutorial.microservico.kafka.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalvarPedidoService {

    private final PedidoRepository pedidoRepository;

    @KafkaListener(topics = "SalvarPedido", groupId = "MicroServicoSalvaPedido")
    public void executar(ConsumerRecord<String, String> record) {
        log.info("Chave = {}", record.key());
        log.info("Cabeçalho = {}", record.headers());
        log.info("Partição = {}", record.partition());

        String strDados = record.value();
        ObjectMapper mapper = new ObjectMapper();
        PedidoData pedidoData;

        try {
            pedidoData = mapper.readValue(strDados, PedidoData.class);
        } catch (JsonProcessingException ex) {
            log.error("Falha ao converter evento [dado= {}]", strDados, ex);
            return;
        }

        log.info("Evento Recebido = {}", pedidoData);
        gravarPedido(pedidoData);
    }

    private void gravarPedido(PedidoData pedidoData) {
        Pedido pedido = new Pedido(pedidoData.getCodigo(), pedidoData.getNomeProduto(), pedidoData.getValor());
        pedidoRepository.save(pedido);
        log.info("Pedido salvo no banco: {}", pedido);
    }
}
