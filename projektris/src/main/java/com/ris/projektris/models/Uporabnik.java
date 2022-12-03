package com.ris.projektris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
public class Uporabnik {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUporabnik;

	@OneToMany(mappedBy = "uporabnik",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ArrayList<Recept> recept;

	@OneToMany(mappedBy = "uporabnik",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ArrayList<Vsecek> vseckaniRecepti;

	@OneToMany(mappedBy = "uporabnik",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ArrayList<Komentar> objavljeniKomentarji;

	@OneToMany(mappedBy = "uporabnik",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ArrayList<Vprasanje> vprasanje;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idOdgovor")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Odgovor odgovor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProfil")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Profil profil;

	private String uporabniskoIme;
	private String geslo;

	public String getUporabniskoIme() {
		return this.uporabniskoIme;
	}

	public void setUporabniskoIme(String uporabniskoIme) {
		this.uporabniskoIme = uporabniskoIme;
	}

	public String getGeslo() {
		return this.geslo;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}

	public Long getIdUporabnik() {
		return idUporabnik;
	}

	public void setIdUporabnik(Long idUporabnik) {
		this.idUporabnik = idUporabnik;
	}

	public ArrayList<Recept> getRecept() {
		return recept;
	}

	public void setRecept(ArrayList<Recept> recept) {
		this.recept = recept;
	}

	public ArrayList<Vsecek> getVseckaniRecepti() {
		return vseckaniRecepti;
	}

	public void setVseckaniRecepti(ArrayList<Vsecek> vseckaniRecepti) {
		this.vseckaniRecepti = vseckaniRecepti;
	}

	public ArrayList<Komentar> getObjavljeniKomentarji() {
		return objavljeniKomentarji;
	}

	public void setObjavljeniKomentarji(ArrayList<Komentar> objavljeniKomentarji) {
		this.objavljeniKomentarji = objavljeniKomentarji;
	}

	public ArrayList<Vprasanje> getVprasanje() {
		return vprasanje;
	}

	public void setVprasanje(ArrayList<Vprasanje> vprasanje) {
		this.vprasanje = vprasanje;
	}

	public Odgovor getOdgovor() {
		return odgovor;
	}

	public void setOdgovor(Odgovor odgovor) {
		this.odgovor = odgovor;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public void vseckajObjavo() {
		// TODO - implement Uporabnik.vseckajObjavo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param vsebina
	 */
	public void objaviKomentar(String vsebina) {
		// TODO - implement Uporabnik.objaviKomentar
		throw new UnsupportedOperationException();
	}

	public ArrayList<Recept> prikazVseckanihReceptov() {
		// TODO - implement Uporabnik.prikazVseckanihReceptov
		throw new UnsupportedOperationException();
	}

}