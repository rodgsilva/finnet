package br.com.finnet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.finnet.domain.Pagamento;
import br.com.finnet.domain.PagamentoDTO;
import br.com.finnet.domain.Pedido;
import br.com.finnet.repositories.PagamentoRepository;
import br.com.finnet.repositories.PedidoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pagamento findOn(Integer id) {
		
		Pagamento obj = pagamentoRepository.findOne(id);
		
		return obj;
	}
	
	public Pagamento findByPedidoDataCliente(Integer pedido, String dataPedido, Integer cliente) {
		Pagamento obj = pagamentoRepository.findByPedidoDataCliente(pedido, dataPedido, cliente);
		return obj;
		
	}
	
	public List<Pagamento> findAll() {
		return pagamentoRepository.findAll();
	}
	
	public Pagamento insert(PagamentoDTO objDTO) {
		
		Pedido ped =  pedidoRepository.findOne(objDTO.getPedido());
		
		Pagamento pag = new Pagamento(objDTO, ped);
		pag = pagamentoRepository.save(pag);
		
				
		pedidoRepository.save(pag.getPedido());
		

			
		return pag;
	}
	
	public void updateCancela(Integer idPagamento) {
		pagamentoRepository.updatePagamento(idPagamento, 2);
	}
	
	
}
