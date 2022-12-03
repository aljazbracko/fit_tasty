package com.ris.projektris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Vprasanje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVprasanje;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUporabnik")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Uporabnik uporabnik;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSpecialist")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Specialist specialist;

	private String vsebina;

	public Uporabnik getUporabnik() {
		return uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	public Specialist getSpecialist() {
		return specialist;
	}

	public void setSpecialist(Specialist specialist) {
		this.specialist = specialist;
	}

	public String getVsebina() {
		return vsebina;
	}

	public void setVsebina(String vsebina) {
		this.vsebina = vsebina;
	}

	public Long getIdVprasanje() {
		return idVprasanje;
	}

	public void setIdVprasanje(Long idVprasanje) {
		this.idVprasanje = idVprasanje;
	}
}