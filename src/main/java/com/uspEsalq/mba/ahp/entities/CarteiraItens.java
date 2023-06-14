package com.uspEsalq.mba.ahp.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carteiraItem")
public class CarteiraItens  implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ativo_id")	
	private Ahp ativoCarteira;
	
	private String nome_ativo;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	private Double  valor_contacao;
	private Integer qtd_acoes;
	private Double  total_investido;
	private Double  rentabilidade;
	private Double  risco;
	private Double  liquidez;
	private Double  volatilidade;
	
	public CarteiraItens() {
	}

	public CarteiraItens(Long id, Ahp ativoCarteira, String nomeAtivo, User client, Double valorContacao, Integer qtdAcoes,
			Double totalInvestido, Double rentabilidade, Double risco, Double liquidez, Double volatilidade) {
		
		this.id = id;
		this.ativoCarteira = ativoCarteira;
		this.nome_ativo = nomeAtivo;
		this.client = client;
		this.valor_contacao = valorContacao;
		this.qtd_acoes = qtdAcoes;
		this.total_investido = totalInvestido;
		this.rentabilidade = rentabilidade;
		this.risco = risco;
		this.liquidez = liquidez;
		this.volatilidade = volatilidade;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ahp getAtivoCarteira() {
		return ativoCarteira;
	}

	public void setAtivoCarteira(Ahp ativoCarteira) {
		this.ativoCarteira = ativoCarteira;
	}

	public String getNome_ativo() {
		return nome_ativo;
	}

	public void setNome_ativo(String nome_ativo) {
		this.nome_ativo = nome_ativo;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Double getValor_contacao() {
		return valor_contacao;
	}

	public void setValor_contacao(Double valor_contacao) {
		this.valor_contacao = valor_contacao;
	}

	public Integer getQtd_acoes() {
		return qtd_acoes;
	}

	public void setQtd_acoes(Integer qtd_acoes) {
		this.qtd_acoes = qtd_acoes;
	}

	public Double getTotal_investido() {
		return total_investido;
	}

	public void setTotal_investido(Double total_investido) {
		this.total_investido = total_investido;
	}

	public Double getRentabilidade() {
		return rentabilidade;
	}

	public void setRentabilidade(Double rentabilidade) {
		this.rentabilidade = rentabilidade;
	}

	public Double getRisco() {
		return risco;
	}

	public void setRisco(Double risco) {
		this.risco = risco;
	}

	public Double getLiquidez() {
		return liquidez;
	}

	public void setLiquidez(Double liquidez) {
		this.liquidez = liquidez;
	}

	public Double getVolatilidade() {
		return volatilidade;
	}

	public void setVolatilidade(Double volatilidade) {
		this.volatilidade = volatilidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarteiraItens other = (CarteiraItens) obj;
		return Objects.equals(id, other.id);
	}
	
}
