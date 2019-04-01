package br.com.finnet.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.finnet.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
	
	@Transactional
	@Query(value="SELECT p FROM Pagamento p, Pedido ped"
	+" WHERE ped.idPedido = p.pedido and p.pedido =:pedido and ped.dtPedido = :dataPedido and ped.cliente = :cliente ")
	 Pagamento findByPedidoDataCliente(@Param("pedido") Integer idPedido,
			 						   @Param("dataPedido") String dtPedido,
			 						   @Param("cliente") Integer cliente );
	@Transactional
	@Query(value="UPDATE Pagamento p set p.estadoPagamento = :estadoPag where p.idPagamento=:idPag")
	void updatePagamento(@Param("idPag")Integer idPagamento,@Param("estadoPag")Integer estadoPagamento);
		
	

}
