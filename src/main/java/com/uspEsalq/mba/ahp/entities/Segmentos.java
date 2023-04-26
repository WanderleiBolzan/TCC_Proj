package com.uspEsalq.mba.ahp.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Segmentos  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String segmento;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "segmento")
//	private List<Empresas> empresas = new ArrayList<>();
	

	public Segmentos() {
	}

	public Segmentos(Long id, String segmento) {
		super();
		this.id = id;
		this.segmento = segmento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSegmento() {
		return segmento;
	}

//	public void setSegmento(String segmento) {
//		this.segmento = segmento;
//	}

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
		Segmentos other = (Segmentos) obj;
		return id == other.id;
	}
	
	
}
