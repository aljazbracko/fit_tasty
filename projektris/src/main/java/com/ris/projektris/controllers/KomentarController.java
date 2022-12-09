package com.ris.projektris.controllers;

import com.ris.projektris.dao.KomentarRepository;
import com.ris.projektris.dao.ReceptRepository;
import com.ris.projektris.dao.UporabnikRepository;
import com.ris.projektris.models.Komentar;
import com.ris.projektris.models.Recept;
import com.ris.projektris.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/komentar")
public class KomentarController {

    @Autowired
    private KomentarRepository komentarDao;

    @Autowired
    private ReceptRepository receptDao;

    @Autowired
    private UporabnikRepository uporabnikDao;

    @GetMapping("/vsi")
    public Iterable<Komentar> vsiKomentarji(){
        return komentarDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Komentar> vrniKomentar(@PathVariable(name="id") Long id){
        return komentarDao.findById(id);
    }

    @DeleteMapping("/izbrisi/{id}")
    public void izbrisiKomentar(@PathVariable(name="id") Long id){
        komentarDao.deleteById(id);
    }

    @PutMapping("/spremeni")
    public Optional<Komentar> spremeniKomentar(@RequestBody Komentar komentar){
        komentarDao.save(komentar);
        return komentarDao.findById(komentar.getIdKomentar());
    }

    @PostMapping("/dodaj")
    public Komentar dodajKomentar(@RequestBody Komentar komentar){
        return komentarDao.save(komentar);
    }

    @PostMapping("/dodajKomentar/{idUporabnik}/{idRecept}")
    public Optional<Komentar> dodajKomentar(@RequestBody Komentar komentar, @PathVariable(name = "idUporabnik") Long idUporabnik, @PathVariable(name = "idRecept") Long idRecept ){
        uporabnikDao.findById(idUporabnik).map(uporabnik ->{
            komentar.setUporabnik(uporabnik);
            return 0;
        });
        return receptDao.findById(idRecept).map(recept -> {
            komentar.setRecept(recept);
            java.util.Date datum = new java.util.Date();
            java.sql.Date sqlDatum = new java.sql.Date(datum.getTime());
            komentar.setCasObjave(sqlDatum);
            return komentarDao.save(komentar);
        });

    }
}
