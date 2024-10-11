package dio.expertostech.tutorial.microservico.kafka.repository;

import dio.expertostech.tutorial.microservico.kafka.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String> {
}
