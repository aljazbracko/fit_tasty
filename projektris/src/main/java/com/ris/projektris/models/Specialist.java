package com.ris.projektris.models;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Specialist extends Uporabnik {


	@OneToMany(mappedBy = "specialist",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ArrayList<Vprasanje> vprasanje;

	@OneToMany(mappedBy = "specialist",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ArrayList<Odgovor> odgovor;

	private String naziv;



	public void setOdgovor(ArrayList<Odgovor> odgovor) {
		this.odgovor = odgovor;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	/**
	 * 
	 * @param vprasanje
	 * @param odgovor
	 */
	public void odgovori(Vprasanje vprasanje, Odgovor odgovor) {
		// TODO - implement Specialist.odgovori
		throw new UnsupportedOperationException();
	}

}