package com.ris.projektris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Odgovor {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long idOdgovor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSpecialist")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Specialist specialist;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUporabnik")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Uporabnik uporabnik;

	private String vsebina;


	public Long getIdOdgovor() {
		return idOdgovor;
	}

	public void setIdOdgovor(Long idOdgovor) {
		this.idOdgovor = idOdgovor;
	}

	public Specialist getSpecialist() {
		return specialist;
	}

	public void setSpecialist(Specialist specialist) {
		this.specialist = specialist;
	}

	public Uporabnik getUporabnik() {
		return uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	public String getVsebina() {
		return vsebina;
	}

	public void setVsebina(String vsebina) {
		this.vsebina = vsebina;
	}
}