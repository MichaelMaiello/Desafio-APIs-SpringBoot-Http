package com.qintess.desafio.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qintess.desafio.entities.pk.ItemPedidoPK;

@Entity
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//Atributo
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	private Integer quantidade;
	private Double preco;
	
	
	//Construtor
	ItemPedido(){
	}

	public ItemPedido(Pedido pedido, Evento evento, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setEvento(evento);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	

	//Método de acesso 
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Evento getEvento() {
		return id.getEvento();
	}
	
	public void setEvento(Evento evento) {
		id.setEvento(evento);
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Double getSubTotal() {
		return preco * quantidade;
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}