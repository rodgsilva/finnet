package br.com.finnet.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.finnet.domain.Pagamento;
import br.com.finnet.service.PagamentoService;

@RestController
@RequestMapping(value="/pagamento")
public class PagamentoResource {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Pagamento> find(@PathVariable Integer id){
		
		
		return null;
	}
}
