package com.ris.projektris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@Entity
public class Recept {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long idRecept;



	private String ime;
	private String opis;
	private int casKuhanja;
	private int steviloKalorij;
	private int steviloOseb;

	@OneToMany(mappedBy = "recept",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Vsecek> vsecki;

	@OneToMany(mappedBy = "recept",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Sestavina> sestavina;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUporabnik")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Uporabnik uporabnik;

	@OneToMany(mappedBy = "recept",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Komentar> komentarji;




	public Long getIdRecept() {
		return idRecept;
	}

	public void setIdRecept(Long idRecept) {
		this.idRecept = idRecept;
	}

	public List<Vsecek> getVsecki() {
		return vsecki;
	}

	public void setVsecki(List<Vsecek> vsecki) {
		this.vsecki = vsecki;
	}

	public List<Sestavina> getSestavina() {
		return sestavina;
	}

	public void setSestavina(List<Sestavina> sestavina) {
		this.sestavina = sestavina;
	}

	public Uporabnik getUporabnik() {
		return uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	public List<Komentar> getKomentarji() {
		return komentarji;
	}

	public void setKomentarji(List<Komentar> komentarji) {
		this.komentarji = komentarji;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getCasKuhanja() {
		return casKuhanja;
	}

	public void setCasKuhanja(int casKuhanja) {
		this.casKuhanja = casKuhanja;
	}

	public void setSteviloKalorij(int steviloKalorij) {
		this.steviloKalorij = steviloKalorij;
	}

	public int getSteviloOseb() {
		return steviloOseb;
	}

	public void setSteviloOseb(int steviloOseb) {
		this.steviloOseb = steviloOseb;
	}

	public int getSteviloKalorij() {
		return this.steviloKalorij;
	}

	public ArrayList<Recept> prikazVSehReceptov() {
		// TODO - implement Recept.prikazVSehReceptov
		throw new UnsupportedOperationException();
	}

}