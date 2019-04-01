package br.com.finnet.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPagamento;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtPagamento;
	private Integer estadoPagamento;
	private String tipoPagamento;
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="pedido")
	private Pedido pedido;
	
	public Pagamento() {
		
	}
	
public Pagamento(PagamentoDTO objDTO, Pedido ped) {
	this.idPagamento = objDTO.getIdPagamento();
	this.dtPagamento = objDTO.getDtPagamento();
	this.estadoPagamento = objDTO.getEstadoPagamento();
	this.tipoPagamento = objDTO.getTipoPagamento();
	this.pedido = ped;

		
	}
	
	public Pagamento(Integer idPagamento, Date dtPagamento, Integer estadoPagamento, String tipoPagamento,
			Pedido pedido) {
		super();
		this.idPagamento = idPagamento;
		this.dtPagamento = dtPagamento;
		this.estadoPagamento = estadoPagamento;
		this.tipoPagamento = tipoPagamento;
		this.pedido = pedido;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPagamento == null) ? 0 : idPagamento.hashCode());
		return result;
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
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (idPagamento == null) {
			if (other.idPagamento != null)
				return false;
		} else if (!idPagamento.equals(other.idPagamento))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Pagamento [idPagamento=" + idPagamento + ", dtPagamento=" + dtPagamento + ", estadoPagamento="
				+ estadoPagamento + ", tipoPagamento=" + tipoPagamento + ", pedido=" + pedido + "]";
	}


	

}
