package br.com.finnet.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.finnet.domain.Pagamento;
import br.com.finnet.domain.PagamentoDTO;
import br.com.finnet.service.PagamentoService;

@RestController
@RequestMapping(value="/pagamento")
public class PagamentoResource {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Pagamento> find(@PathVariable Integer id){
			
		Pagamento obj = pagamentoService.findOn(id);
		 return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Pagamento>> findAll(){
			
		List<Pagamento> obj = pagamentoService.findAll();
		 return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PagamentoDTO DTOobj){
			
		 pagamentoService.insert(DTOobj);
		 
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(DTOobj.getIdPagamento()).toUri();
		 
		 return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> cancela(@PathVariable Integer idPath, @RequestHeader(value = "idPag",defaultValue="0", required=false)Integer idHead){
		Integer id;
		if (idHead ==0 ) {
		id = idPath;			
			
		} else {
			id = idHead;
		}
		
		pagamentoService.updateCancela(id);
		return ResponseEntity.noContent().build();
		
	}
	
}
