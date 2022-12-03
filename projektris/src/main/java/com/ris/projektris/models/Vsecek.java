package com.ris.projektris.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Vsecek {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVsecek;

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

    public Long getIdVsecek() {
        return idVsecek;
    }

    public void setIdVsecek(Long idVsecek) {
        this.idVsecek = idVsecek;
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
}
