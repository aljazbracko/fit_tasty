package com.ris.projektris.controllers;

import com.ris.projektris.dao.ReceptRepository;
import com.ris.projektris.dao.UporabnikRepository;
import com.ris.projektris.models.Recept;
import com.ris.projektris.models.Uporabnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
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
        boolean obstaja = uporabnikDao.existsByUporabniskoIme(uporabnik.getUporabniskoIme());
        System.out.println(obstaja);
        if(!obstaja){
            return uporabnikDao.save(uporabnik);
        }
        return null;

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
    public Iterable<Uporabnik> uporabnikGledeNaSteviloOsebRecepta(@PathVariable(name="steviloOseb") int stOseb){
        return uporabnikDao.vrniUporabnikeGledeNaSteviloOsebRecepta(stOseb);
    }


    @GetMapping("/uporabnikGledeNaCasKuhanjaRecepta/{casKuhanja}")
    public Iterable<Uporabnik> uporabnikGledeNaCasKuhanjaRecepta(@PathVariable(name="casKuhanja") int casKuhanja){
        return uporabnikDao.vrniUporabnikeGledeNaCasKuhanjaRecepta(casKuhanja);
    }

    @PostMapping("/prijava")
    public Uporabnik prijavaUporabnik(@RequestBody Uporabnik uporabnik){
        Iterable uporabniki = uporabnikDao.findAll();
        for(Object u : uporabniki){
            Uporabnik vmesni = (Uporabnik)u;
            if(vmesni.getUporabniskoIme().equals(uporabnik.getUporabniskoIme()) && vmesni.getGeslo().equals(uporabnik.getGeslo())){
                return vmesni;
            }
        }
        return null;
    }
}

