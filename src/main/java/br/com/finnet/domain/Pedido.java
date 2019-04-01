package br.com.finnet.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPedido;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtPedido;
	
	private Integer itemPedido;
	
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private Pagamento pagamento;

	public Pedido() {
		
	}

	public Pedido(Integer idPedido, Date dtPedido, Integer itemPedido, Cliente cliente, Pagamento pagamento) {
		super();
		this.idPedido = idPedido;
		this.dtPedido = dtPedido;
		this.itemPedido = itemPedido;
		this.cliente = cliente;
		this.pagamento = pagamento;
	}


	public Integer getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}


	public Date getDtPedido() {
		return dtPedido;
	}


	public void setDtPedido(Date dtPedido) {
		this.dtPedido = dtPedido;
	}


	public Integer getItemPedido() {
		return itemPedido;
	}


	public void setItemPedido(Integer itemPedido) {
		this.itemPedido = itemPedido;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}


	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", dtPedido=" + dtPedido + ", itemPedido=" + itemPedido + ", cliente="
				+ cliente + ", pagamento=" + pagamento + "]";
	}

	

}
