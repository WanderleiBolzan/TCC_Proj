package com.uspEsalq.mba.ahp.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_carteira")
public class Carteira implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String  nome_ativo;
	private Double  valor_cotacao;
	private Integer qtd_acoes;
	private Double  preco_venda;
	private Double  total_investido;
	private Double  rentabilidade;
	private Double  risco;
	private Double  liquidez;
	private Double  volatilidade;
	

	public Carteira() {
	}


	public Carteira(long id, String nome_ativo, Double valor_cotacao, Integer qtd_acoes, Double preco_venda, Double total_investido,
			Double rentabilidade, Double risco, Double liquidez, Double volatilidade) {
		super();
		this.id = id;
		this.nome_ativo = nome_ativo;
		this.valor_cotacao = valor_cotacao;
		this.qtd_acoes = qtd_acoes;
		this.preco_venda = preco_venda;
		this.total_investido = total_investido;
		this.rentabilidade = rentabilidade;
		this.risco = risco;
		this.liquidez = liquidez;
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
		Carteira other = (Carteira) obj;
		return id == other.id;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome_ativo() {
		return nome_ativo;
	}


	public void setNome_ativo(String nome_ativo) {
		this.nome_ativo = nome_ativo;
	}


	public Double getValor_cotacao() {
		return valor_cotacao;
	}


	public void setValor_cotacao(Double valor_cotacao) {
		this.valor_cotacao = valor_cotacao;
	}


	public Integer getQtd_acoes() {
		return qtd_acoes;
	}


	public void setQtd_acoes(Integer qtd_acoes) {
		this.qtd_acoes = qtd_acoes;
	}


	public Double getPreco_venda() {
		return preco_venda;
	}


	public void setPreco_venda(Double preco_venda) {
		this.preco_venda = preco_venda;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
