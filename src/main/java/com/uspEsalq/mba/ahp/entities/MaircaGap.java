package com.uspEsalq.mba.ahp.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_marica_Gap")
public class MaircaGap implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String acoes;
	private Double valor;
	private Double rentabilidade;
	private Double risco;
	private Double volatilidade;
	private Double liquidez;
	
	public MaircaGap() {	
	}

	public MaircaGap(Long id, String acoes, Double valor, Double rentabilidade, Double risco,
			Double volatilidade, Double liquidez) {
		
		super();
		this.id = id;
		this.acoes = acoes;
		this.valor = valor;
		this.rentabilidade = rentabilidade;
		this.risco = risco;
		this.volatilidade = volatilidade;
		this.liquidez = liquidez;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "MaricaDecisaoReal [id=" + id + ", acoes=" + acoes + ", valor=" + valor + ", rentabilidade="
				+ rentabilidade + ", risco=" + risco + ", volatilidade=" + volatilidade + ", liquidez=" + liquidez
				+ "]";
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcoes() {
		return acoes;
	}

	public void setAcoes(String acoes) {
		this.acoes = acoes;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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

	public Double getVolatilidade() {
		return volatilidade;
	}

	public void setVolatilidade(Double volatilidade) {
		this.volatilidade = volatilidade;
	}

	public Double getLiquidez() {
		return liquidez;
	}

	public void setLiquidez(Double liquidez) {
		this.liquidez = liquidez;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
