package com.qintess.desafio.entities;



import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qintess.desafio.entities.enums.PedidoStatus;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	//Atributo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern =  "yyyy-MM-dd'T'HH:mm:ss'z'", timezone = "GMT")
	private Instant data;
	private Integer pedidoStatus;
	
	
	//Associação 
		//Cliente
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Cliente client;
		//ItemPedido
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
		//Pagamento
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagemento;
	
	
	//construtor
	public Pedido() {
	}
	
	public Pedido(Long id, Instant data, PedidoStatus pedidoStatus, Cliente client) {
		super();
		this.id = id;
		this.data = data;
		setPedidoStatus(pedidoStatus);
		this.client = client;
	}


	
	//Métodos de acesso 
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Instant getData() {
		return data;
	}


	public void setData(Instant data) {
		this.data = data;
	}

	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valueOf(pedidoStatus);
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if (pedidoStatus != null) {
			this.pedidoStatus = pedidoStatus.getCodigo();
		}
	}

	public Cliente getClient() {
		return client;
	}
	
	public void setClient(Cliente client) {
		this.client = client;
	}
	
	public Pagamento getPagemento() {
		return pagemento;
	}

	public void setPagemento(Pagamento pagemento) {
		this.pagemento = pagemento;
	}

	public Set<ItemPedido> getItens(){
		return itens; 
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for(ItemPedido x : itens) {
			sum += x.getSubTotal();
		}
		return sum;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
