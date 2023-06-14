package com.uspEsalq.mba.ahp.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tb_ahp")
public class Ahp  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String ativo;
	private LocalDate data;
	private Long Id_Segmento;
	private Long Id_Empresa;	
	private Double Abertura;
	private Double Maxima;
	private Double Minima;
	private Double Fechamento;
	private LocalDate DataCompra;
	private Double Cotacao;
	private Integer QtdAcoes;
	private Double TotInvest;
	private Double CotacaoAtual;
	private Double ValorAtual;
	private Double Rentabilidade;
	private Double Risco;
	private Double Liquidez;
	private Double Volatilidade;
	
	public Ahp() {
	}
	
	public Ahp(Long id, String ativo, LocalDate data, Long id_Segmento, Long id_Empresa, Double abertura, Double maxima, Double minima, Double fechamento,
			LocalDate dataCompra, Double cotacao, Integer qtdAcoes, Double totInvest, Double cotacaoAtual,
			Double valorAtual, Double rentabilidade, Double risco, Double liquidez, Double volatilidade) {
		super();
		
		this.id = id;
		this.ativo = ativo;
		this.data = data;
		this.Id_Segmento = id_Segmento;
		this.Id_Empresa = id_Empresa;
		this.Abertura = abertura;
		this.Maxima = maxima;
		this.Minima = minima;
		this.Fechamento = fechamento;
		this.DataCompra = dataCompra;
		this.Cotacao = cotacao;
		this.QtdAcoes = qtdAcoes;
		this.TotInvest = totInvest;
		this.CotacaoAtual = cotacaoAtual;
		this.ValorAtual = valorAtual;
		this.Rentabilidade = rentabilidade;
		this.Risco = risco;
		this.Liquidez = liquidez;
		this.Volatilidade = volatilidade;
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
		Ahp other = (Ahp) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Long getId_Segmento() {
		return Id_Segmento;
	}

	public void setId_Segmento(Long id_Segmento) {
		this.Id_Segmento = id_Segmento;
	}

	public Long getId_Empresa() {
		return Id_Empresa;
	}

	public void setId_Empresa(Long id_Empresa) {
		this.Id_Empresa = id_Empresa;
	}
	
	
	public Double getAbertura() {
		return Abertura;
	}

	public void setAbertura(Double abertura) {
		this.Abertura = abertura;
	}

	public Double getMaxima() {
		return Maxima;
	}

	public void setMaxima(Double maxima) {
		this.Maxima = maxima;
	}

	public Double getMinima() {
		return Minima;
	}

	public void setMinima(Double minima) {
		this.Minima = minima;
	}

	public Double getFechamento() {
		return Fechamento;
	}

	public void setFechamento(Double fechamento) {
		this.Fechamento = fechamento;
	}

	public LocalDate getDataCompra() {
		return DataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.DataCompra = dataCompra;
	}

	public Double getCotacao() {
		return Cotacao;
	}

	public void setCotacao(Double cotacao) {
		this.Cotacao = cotacao;
	}

	public Integer getQtdAcoes() {
		return QtdAcoes;
	}

	public void setQtdAcoes(Integer qtdAcoes) {
		this.QtdAcoes = qtdAcoes;
	}

	public Double getTotInvest() {
		return TotInvest;
	}

	public void setTotInvest(Double totInvest) {
		this.TotInvest = totInvest;
	}

	public Double getCotacaoAtual() {
		return CotacaoAtual;
	}

	public void setCotacaoAtual(Double cotacaoAtual) {
		this.CotacaoAtual = cotacaoAtual;
	}

	public Double getValorAtual() {
		return ValorAtual;
	}

	public void setValorAtual(Double valorAtual) {
		this.ValorAtual = valorAtual;
	}

	public Double getRentabilidade() {
		return Rentabilidade;
	}

	public void setRentabilidade(Double rentabilidade) {
		this.Rentabilidade = rentabilidade;
	}

	public Double getRisco() {
		return Risco;
	}

	public void setRisco(Double risco) {
		this.Risco = risco;
	}

	public Double getLiquidez() {
		return Liquidez;
	}

	public void setLiquidez(Double liquidez) {
		this.Liquidez = liquidez;
	}

	public Double getVolatilidade() {
		return Volatilidade;
	}

	public void setVolatilidade(Double volatilidade) {
		this.Volatilidade = volatilidade;
	}
}
