package com.ris.projektris.controllers;

import com.ris.projektris.dao.ReceptRepository;
import com.ris.projektris.dao.UporabnikRepository;
import com.ris.projektris.models.Recept;
import com.ris.projektris.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/uporabnik")
public class UporabnikController {

    @Autowired
    private UporabnikRepository uporabnikDao;

    @Autowired
    private ReceptRepository receptDao;

    @GetMapping("/vsi")
    public Iterable<Uporabnik> vsiUporabniki(){
        return uporabnikDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Uporabnik> vrniUporabnika(@PathVariable(name="id") Long id){
        return uporabnikDao.findById(id);
    }

    @PostMapping("/dodaj")
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik uporabnik){
        return uporabnikDao.save(uporabnik);
    }

    @DeleteMapping("/izbrisi/{id}")
    public void izbrisiUporabnika(@PathVariable(name="id") Long id){
        uporabnikDao.deleteById(id);
    }

    @PutMapping("/spremeni")
    public Optional<Uporabnik> spremeniUporabnika(@RequestBody Uporabnik uporabnik){
        uporabnikDao.save(uporabnik);
        return uporabnikDao.findById(uporabnik.getIdUporabnik());
    }

    @PostMapping("/dodajRecept/{id}")
    public Optional<Recept> dodajRecept(@RequestBody Recept recept, @PathVariable(name = "id") Long id ){
        return uporabnikDao.findById(id).map(uporabnik -> {
            recept.setUporabnik(uporabnik);
            return receptDao.save(recept);
        });
    }

    /*
    @GetMapping("/isciUporabnike/{kalorije}/{stOseb}/{cas}")
    public Iterable<Uporabnik> iscikalorijeosebecas(@PathVariable(name="kalorije") int kalorije, @PathVariable(name="stOseb") int stOseb,@PathVariable(name="cas") int cas){
        return uporabnikDao.findBykalorijeosebecas(kalorije,stOseb,cas);
    }

     */

    //sprint2
    @GetMapping("/uporabnikGledeNaSteviloOsebRecepta/{steviloOseb}")
    public Optional<Uporabnik> uporabnikGledeNaSteviloOsebRecepta(@PathVariable(name="steviloOseb") int stOseb){
        return uporabnikDao.vrniUporabnikeGledeNaSteviloOsebRecepta(stOseb);
    }

}

