package br.com.finnet.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PagamentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
		
	private Integer idPagamento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtPagamento;
	private Integer estadoPagamento;
	private String tipoPagamento;
	
	private Integer pedido;
	
	public PagamentoDTO() {
		
	}

	public PagamentoDTO(Integer idPagamento, Date dtPagamento, Integer estadoPagamento, String tipoPagamento,
			Integer pedido) {
		super();
		this.idPagamento = idPagamento;
		this.dtPagamento = dtPagamento;
		this.estadoPagamento = estadoPagamento;
		this.tipoPagamento = tipoPagamento;
		this.pedido = pedido;
	}

	public Integer getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Integer idPagamento) {
		this.idPagamento = idPagamento;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public Integer getEstadoPagamento() {
		return estadoPagamento;
	}

	public void setEstadoPagamento(Integer estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Integer getPedido() {
		return pedido;
	}

	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}
	
	

}
