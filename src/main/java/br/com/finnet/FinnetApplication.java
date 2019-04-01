package br.com.finnet;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.finnet.domain.Cliente;
import br.com.finnet.domain.Pagamento;
import br.com.finnet.domain.Pedido;
import br.com.finnet.repositories.ClienteRepository;
import br.com.finnet.repositories.PagamentoRepository;
import br.com.finnet.repositories.PedidoRepository;

@SpringBootApplication
public class FinnetApplication implements CommandLineRunner{
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(FinnetApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Iniciar os insert");
		
		Cliente cli = new Cliente(1, "Nome Teste",sdf.parse("19/12/1983"));
		
		cli = clienteRepository.save(cli);
		
		System.out.println("Cliente insert");
		
		Pedido ped = new Pedido(1, sdf.parse("01/04/2019"), 1, cli);
		
		ped = pedidoRepository.save(ped);
		
		System.out.println("Pedido insert");
		
		System.out.println(ped);
		
		Pagamento pag = new Pagamento(1, sdf.parse("01/04/2019"), 1, "Din", ped);
		
		System.out.println(pag);
		
		ped.setPagamento(Arrays.asList(pag));
		
		pedidoRepository.save(ped);
		
		pag = pagamentoRepository.save(pag);
		
		System.out.println("Pag insert");
		
		
		
	}

}
