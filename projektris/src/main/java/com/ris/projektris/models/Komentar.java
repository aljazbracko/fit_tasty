package com.ris.projektris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
public class Komentar {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long idKomentar;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUporabnik")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Uporabnik uporabnik;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRecept")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Recept recept;


	private Date casObjave;
	private String besedilo;


	public Long getIdKomentar() {
		return idKomentar;
	}

	public void setIdKomentar(Long idKomentar) {
		this.idKomentar = idKomentar;
	}

	public Uporabnik getUporabnik() {
		return uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	public Recept getRecept() {
		return recept;
	}

	public void setRecept(Recept recept) {
		this.recept = recept;
	}

	public Date getCasObjave() {
		return casObjave;
	}

	public void setCasObjave(Date casObjave) {
		this.casObjave = casObjave;
	}

	public String getBesedilo() {
		return besedilo;
	}

	public void setBesedilo(String besedilo) {
		this.besedilo = besedilo;
	}
}