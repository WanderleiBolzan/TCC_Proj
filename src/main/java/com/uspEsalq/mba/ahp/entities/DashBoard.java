package com.uspEsalq.mba.ahp.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TbDashBoard")
public class DashBoard  implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	private Long id;
	private String DataMenorCotacao;
	private String dataMaiorCotacao;
	private String Ticket_Min;
	private String Ticket_Max;
	private Double price_openMin;
	private Double price_openMed; 
	private Double price_openMax;
	private Double price_highMin;
	private Double price_highMed;
	private Double price_highMax;
	private Double price_lowMin;
	private Double price_lowMed;
	private Double price_lowMax;
	private Double price_closeMin;
	private Double price_closeMed;
	private Double price_closeMax;
	private Double price_VolumeMin;
	private Double price_VolumeMed;
	private Double price_VolumeMax;
	private Double price_adjustedMin;
	private Double price_adjustedMed;
	private Double price_adjustedMax;
	
	public DashBoard() {
	}

	public DashBoard(Long id, String dataMenorCotacao, String dataMaiorCotacao, String ticket_Min,
			String ticket_Max, Double price_openMin, Double price_openMed, Double price_openMax, Double price_highMin,
			Double price_highMed, Double price_highMax, Double price_lowMin, Double price_lowMed, Double price_lowMax,
			Double price_closeMin, Double price_closeMed, Double price_closeMax, Double price_VolumeMin,
			Double price_VolumeMed, Double price_VolumeMax, Double price_adjustedMin, Double price_adjustedMed,
			Double price_adjustedMax) {
		super();
		this.id = id;
		DataMenorCotacao = dataMenorCotacao;
		this.dataMaiorCotacao = dataMaiorCotacao;
		Ticket_Min = ticket_Min;
		Ticket_Max = ticket_Max;
		this.price_openMin = price_openMin;
		this.price_openMed = price_openMed;
		this.price_openMax = price_openMax;
		this.price_highMin = price_highMin;
		this.price_highMed = price_highMed;
		this.price_highMax = price_highMax;
		this.price_lowMin = price_lowMin;
		this.price_lowMed = price_lowMed;
		this.price_lowMax = price_lowMax;
		this.price_closeMin = price_closeMin;
		this.price_closeMed = price_closeMed;
		this.price_closeMax = price_closeMax;
		this.price_VolumeMin = price_VolumeMin;
		this.price_VolumeMed = price_VolumeMed;
		this.price_VolumeMax = price_VolumeMax;
		this.price_adjustedMin = price_adjustedMin;
		this.price_adjustedMed = price_adjustedMed;
		this.price_adjustedMax = price_adjustedMax;
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
		DashBoard other = (DashBoard) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "DashBoard [id=" + id + ", DataMenorCotacao=" + DataMenorCotacao + ", dataMaiorCotacao="
				+ dataMaiorCotacao + ", Ticket_Min=" + Ticket_Min + ", Ticket_Max=" + Ticket_Max + ", price_openMin="
				+ price_openMin + ", price_openMed=" + price_openMed + ", price_openMax=" + price_openMax
				+ ", price_highMin=" + price_highMin + ", price_highMed=" + price_highMed + ", price_highMax="
				+ price_highMax + ", price_lowMin=" + price_lowMin + ", price_lowMed=" + price_lowMed
				+ ", price_lowMax=" + price_lowMax + ", price_closeMin=" + price_closeMin + ", price_closeMed="
				+ price_closeMed + ", price_closeMax=" + price_closeMax + ", price_VolumeMin=" + price_VolumeMin
				+ ", price_VolumeMed=" + price_VolumeMed + ", price_VolumeMax=" + price_VolumeMax
				+ ", price_adjustedMin=" + price_adjustedMin + ", price_adjustedMed=" + price_adjustedMed
				+ ", price_adjustedMax=" + price_adjustedMax + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataMenorCotacao() {
		return DataMenorCotacao;
	}

	public void setDataMenorCotacao(String dataMenorCotacao) {
		DataMenorCotacao = dataMenorCotacao;
	}

	public String getDataMaiorCotacao() {
		return dataMaiorCotacao;
	}

	public void setDataMaiorCotacao(String dataMaiorCotacao) {
		this.dataMaiorCotacao = dataMaiorCotacao;
	}

	public String getTicket_Min() {
		return Ticket_Min;
	}

	public void setTicket_Min(String ticket_Min) {
		Ticket_Min = ticket_Min;
	}

	public String getTicket_Max() {
		return Ticket_Max;
	}

	public void setTicket_Max(String ticket_Max) {
		Ticket_Max = ticket_Max;
	}

	public Double getPrice_openMin() {
		return price_openMin;
	}

	public void setPrice_openMin(Double price_openMin) {
		this.price_openMin = price_openMin;
	}

	public Double getPrice_openMed() {
		return price_openMed;
	}

	public void setPrice_openMed(Double price_openMed) {
		this.price_openMed = price_openMed;
	}

	public Double getPrice_openMax() {
		return price_openMax;
	}

	public void setPrice_openMax(Double price_openMax) {
		this.price_openMax = price_openMax;
	}

	public Double getPrice_highMin() {
		return price_highMin;
	}

	public void setPrice_highMin(Double price_highMin) {
		this.price_highMin = price_highMin;
	}

	public Double getPrice_highMed() {
		return price_highMed;
	}

	public void setPrice_highMed(Double price_highMed) {
		this.price_highMed = price_highMed;
	}

	public Double getPrice_highMax() {
		return price_highMax;
	}

	public void setPrice_highMax(Double price_highMax) {
		this.price_highMax = price_highMax;
	}

	public Double getPrice_lowMin() {
		return price_lowMin;
	}

	public void setPrice_lowMin(Double price_lowMin) {
		this.price_lowMin = price_lowMin;
	}

	public Double getPrice_lowMed() {
		return price_lowMed;
	}

	public void setPrice_lowMed(Double price_lowMed) {
		this.price_lowMed = price_lowMed;
	}

	public Double getPrice_lowMax() {
		return price_lowMax;
	}

	public void setPrice_lowMax(Double price_lowMax) {
		this.price_lowMax = price_lowMax;
	}

	public Double getPrice_closeMin() {
		return price_closeMin;
	}

	public void setPrice_closeMin(Double price_closeMin) {
		this.price_closeMin = price_closeMin;
	}

	public Double getPrice_closeMed() {
		return price_closeMed;
	}

	public void setPrice_closeMed(Double price_closeMed) {
		this.price_closeMed = price_closeMed;
	}

	public Double getPrice_closeMax() {
		return price_closeMax;
	}

	public void setPrice_closeMax(Double price_closeMax) {
		this.price_closeMax = price_closeMax;
	}

	public Double getPrice_VolumeMin() {
		return price_VolumeMin;
	}

	public void setPrice_VolumeMin(Double price_VolumeMin) {
		this.price_VolumeMin = price_VolumeMin;
	}

	public Double getPrice_VolumeMed() {
		return price_VolumeMed;
	}

	public void setPrice_VolumeMed(Double price_VolumeMed) {
		this.price_VolumeMed = price_VolumeMed;
	}

	public Double getPrice_VolumeMax() {
		return price_VolumeMax;
	}

	public void setPrice_VolumeMax(Double price_VolumeMax) {
		this.price_VolumeMax = price_VolumeMax;
	}

	public Double getPrice_adjustedMin() {
		return price_adjustedMin;
	}

	public void setPrice_adjustedMin(Double price_adjustedMin) {
		this.price_adjustedMin = price_adjustedMin;
	}

	public Double getPrice_adjustedMed() {
		return price_adjustedMed;
	}

	public void setPrice_adjustedMed(Double price_adjustedMed) {
		this.price_adjustedMed = price_adjustedMed;
	}

	public Double getPrice_adjustedMax() {
		return price_adjustedMax;
	}

	public void setPrice_adjustedMax(Double price_adjustedMax) {
		this.price_adjustedMax = price_adjustedMax;
	}
	
	
}

