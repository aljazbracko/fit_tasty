package com.ris.projektris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Profil {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long idProfil;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUporabnik")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Uporabnik uporabnik;

	private double teza;
	private int starost;
	private String spol;
	private String aktivnost;

	public Long getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(Long idProfil) {
		this.idProfil = idProfil;
	}

	public Uporabnik getUporabnik() {
		return uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	public double getTeza() {
		return teza;
	}

	public void setTeza(double teza) {
		this.teza = teza;
	}

	public int getStarost() {
		return starost;
	}

	public void setStarost(int starost) {
		this.starost = starost;
	}

	public String getSpol() {
		return spol;
	}

	public void setSpol(String spol) {
		this.spol = spol;
	}

	public String getAktivnost() {
		return aktivnost;
	}

	public void setAktivnost(String aktivnost) {
		this.aktivnost = aktivnost;
	}

	/**
	 * 
	 * @param teza
	 * @param starost
	 * @param aktivnost
	 * @param spol
	 */
	public void izracunKalorij(double teza, int starost, String aktivnost, String spol) {
		// TODO - implement Profil.izracunKalorij
		throw new UnsupportedOperationException();
	}

}