package com.qintess.desafio.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Instant data;
	private Integer qtdIngresso;
	private Double preco;

	// Associação
	@ManyToMany
	@JoinTable(name = "evento_casashow", joinColumns = @JoinColumn(name = "evonto_id"), inverseJoinColumns = @JoinColumn(name = "casashow_id"))
	private Set<CasaShow> casas = new HashSet<>();

	@OneToMany(mappedBy = "id.evento")
	private Set<ItemPedido> itens = new HashSet<>();
	
	
	// Construtor
	public Evento() {
	}

	public Evento(Long id, String nome, String descricao, Instant data, Integer qtdIngresso, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.qtdIngresso = qtdIngresso;
		this.preco = preco;
	}

	// Método de acesso
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricacao) {
		this.descricao = descricacao;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Integer getQtdIngresso() {
		return qtdIngresso;
	}

	public void setQtdIngresso(Integer qtdIngresso) {
		this.qtdIngresso = qtdIngresso;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Set<CasaShow> getCasas() {
		return casas;
	}
	
	@JsonIgnore
	public Set<Pedido> getPedidos(){
		Set<Pedido> set = new HashSet<>();
		for (ItemPedido x : itens) {
			set.add(x.getPedido());
		}
		return set;
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
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
