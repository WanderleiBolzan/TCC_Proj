package com.uspEsalq.mba.ahp.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_marica_Peso")
public class MaircaMatrizPeso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private Double valor;
	private Double rentabilidade;
	private Double risco;
	private Double volatilidade;
	private Double liquidez;
	private Double pai;
	
	public MaircaMatrizPeso() {
		
	}

	public MaircaMatrizPeso(Long id, Double valor, Double rentabilidade, Double risco, Double volatilidade,
			Double liquidez, Double pai) {
		super();
		this.id = id;
		this.valor = valor;
		this.rentabilidade = rentabilidade;
		this.risco = risco;
		this.volatilidade = volatilidade;
		this.liquidez = liquidez;
		this.pai = pai;
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
		MaircaMatrizPeso other = (MaircaMatrizPeso) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "MaircaMatrizPeso [id=" + id + ", valor=" + valor + ", rentabilidade=" + rentabilidade + ", risco="
				+ risco + ", volatilidade=" + volatilidade + ", liquidez=" + liquidez + ", pai=" + pai + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getPai() {
		return pai;
	}

	public void setPai(Double pai) {
		this.pai = pai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
