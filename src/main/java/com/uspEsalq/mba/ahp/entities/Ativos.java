package com.uspEsalq.mba.ahp.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tb_Ativos")
public class Ativos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ativo;
	private Long id_Segmento; 
	private Long id_Empresa;
	private LocalDate data;
	private Double abertura;
	private Double maxima;
	private Double minima;
	private Double fechamento;
	private Double volume;
	private Double preco_ajustado;
	private Double maxima_Anterior;
	private Double minima_Anterior;
	private Double compra;
	private Double venda;
	private Double resultados;

//	@ManyToMany
//	@JoinTable(name = "ativos_empresas", joinColumns = @JoinColumn(name = "ativo_id"),inverseJoinColumns = @JoinColumn(name = "empresa_id"))
//	private Set<Empresas> empresas = new HashSet<>();
	
//	@OneToMany(mappedBy = "id.ativos")
//	private Set<CarteiraItem> items = new HashSet<>();
	
	public Ativos() {	
	}

	public Ativos(Long id, String ativo, Long id_Segmento, Long id_Empresa, LocalDate data,
				  Double abertura,Double maxima,Double minima,Double fechamento,Double volume,Double preco_ajustado,
				  Double maxima_Anterior,	Double minima_Anterior,	Double compra,Double venda,Double resultados) {
		super();
		this.id = id;
		this.ativo = ativo;
		this.id_Segmento = id_Segmento;
		this.id_Empresa = id_Empresa;
		this.data = data;
		this.abertura = abertura;
		this.maxima = maxima;
		this.minima = minima;
		this.fechamento = fechamento;
		this.volume = volume;
		this.preco_ajustado = preco_ajustado;
		this.maxima_Anterior = maxima_Anterior;
		this.minima_Anterior = minima_Anterior;
		this.compra = compra;
		this.venda = venda;
		this.resultados = resultados;		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_Segmento() {
		return id_Segmento;
	}

	public void setId_Segmento(Long id_Segmento) {
		this.id_Segmento = id_Segmento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId_Empresa() {
		return id_Empresa;
	}

//	public void setEmpresas(Set<Empresas> empresas) {
//		this.empresas = empresas;
//	}

	public void setId_Empresa(Long id_Empresa) {
		this.id_Empresa = id_Empresa;
	}

//	public Set<Empresas> getEmpresas() {
//		/return empresas;
//	}
	
	public LocalDate getdata() {
		return data;
	}

	public void setData(LocalDate data) {
		data = data;
	}

	public Double getAbertura() {
		return abertura;
	}

	public void setAbertura(Double abertura) {
		this.abertura = abertura;
	}

	public Double getMaxima() {
		return maxima;
	}

	public void setMaxima(Double maxima) {
		this.maxima = maxima;
	}

	public Double getMinima() {
		return minima;
	}

	public void setMinima(Double minima) {
		this.minima = minima;
	}

	public Double getFechamento() {
		return fechamento;
	}

	public void setFechamento(Double fechamento) {
		this.fechamento = fechamento;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getPreco_ajustado() {
		return preco_ajustado;
	}

	public void setPreco_ajustado(Double preco_ajustado) {
		this.preco_ajustado = preco_ajustado;
	}

	public Double getMaxima_Anterior() {
		return maxima_Anterior;
	}

	public void setMaxima_Anterior(Double maxima_Anterior) {
		this.maxima_Anterior = maxima_Anterior;
	}

	public Double getMinima_Anterior() {
		return minima_Anterior;
	}

	public void setMinima_Anterior(Double minima_Anterior) {
		this.minima_Anterior = minima_Anterior;
	}

	public Double getCompra() {
		return compra;
	}

	public void setCompra(Double compra) {
		this.compra = compra;
	}

	public Double getVenda() {
		return venda;
	}

	public void setVenda(Double venda) {
		this.venda = venda;
	}

	public Double getResultados() {
		return resultados;
	}

	public void setResultados(Double resultados) {
		this.resultados = resultados;
	}
	

	@JsonIgnore
	public Set<Carteira> getCarteiras() {
		Set<Carteira> set = new HashSet<>();
		return set;
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
		Ativos other = (Ativos) obj;
		return Objects.equals(id, other.id);
	}
}
