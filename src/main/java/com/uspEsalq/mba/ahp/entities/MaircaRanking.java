package com.uspEsalq.mba.ahp.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_marica_Ranking")
public class MaircaRanking  implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String acao;
	private Double somaGap;
	private Integer ranking;
	
	public MaircaRanking() {
		
	}

	public MaircaRanking(Long id, String acao, Double somaGap, Integer ranking) {
		super();
		this.id = id;
		this.acao = acao;
		this.somaGap = somaGap;
		this.ranking = ranking;
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
		MaircaRanking other = (MaircaRanking) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "MaircaRanking [id=" + id + ", acao=" + acao + ", somaGap=" + somaGap + ", ranking=" + ranking + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Double getSomaGap() {
		return somaGap;
	}

	public void setSomaGap(Double somaGap) {
		this.somaGap = somaGap;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
