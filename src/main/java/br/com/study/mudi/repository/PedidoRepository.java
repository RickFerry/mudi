package br.com.study.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.study.mudi.model.Pedido;
import br.com.study.mudi.model.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	List<Pedido> findByStatus(StatusPedido status);
}
