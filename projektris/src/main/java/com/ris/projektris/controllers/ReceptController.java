package com.ris.projektris.controllers;

import com.ris.projektris.dao.ReceptRepository;
import com.ris.projektris.models.Recept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recept")
public class ReceptController{

    @Autowired
    private ReceptRepository receptDao;


    @GetMapping("/vsi")
    public Iterable<Recept> vsiRecepti(){
        return receptDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Recept> vrniRecept(@PathVariable(name="id") Long id){
        return receptDao.findById(id);
    }

    @PostMapping("/dodaj")
    public Recept dodajRecept(@RequestBody Recept recept){
        return receptDao.save(recept);
    }

    @DeleteMapping("/izbrisi/{id}")
    public void izbrisiRecept(@PathVariable(name="id") Long id){
        receptDao.deleteById(id);
    }

    @PutMapping("/spremeni")
    public Optional<Recept> spremeniRecept(@RequestBody Recept recept){
        receptDao.save(recept);
        return receptDao.findById(recept.getIdRecept());
    }

    @GetMapping("/isciKalorijeOsebeManj/{kalorije}/{stOseb}")
    public Iterable<Recept> isciKalorijeOsebeManj(@PathVariable(name="kalorije") int kalorije, @PathVariable(name="stOseb") int stOseb){
        return receptDao.findBykalorijeosebeManj(kalorije,stOseb);
    }

    @GetMapping("/isciKalorijeOsebeCasManj/{kalorije}/{stOseb}/{cas}")
    public Iterable<Recept> isciKalorijeOsebeCasManj(@PathVariable(name="kalorije") int kalorije, @PathVariable(name="stOseb") int stOseb,@PathVariable(name="cas") int cas){
        return receptDao.findBykalorijeosebecasManj(kalorije,stOseb,cas);
    }

    @GetMapping("/isciKalorijeOsebeCas/{kalorije}/{stOseb}/{cas}")
    public Iterable<Recept> isciKalorijeOsebeCasVec(@PathVariable(name="kalorije") int kalorije, @PathVariable(name="stOseb") int stOseb,@PathVariable(name="cas") int cas){
        return receptDao.findBykalorijeosebecasVec(kalorije,stOseb,cas);
    }

    @GetMapping("/isciKalorijeOsebe/{kalorije}/{stOseb}")
    public Iterable<Recept> isciKalorijeOsebe(@PathVariable(name="kalorije") int kalorije, @PathVariable(name="stOseb") int stOseb){
        return receptDao.findBykalorijeosebe(kalorije, stOseb);
    }

    @GetMapping("/vrniRecepteGledeNaSteviloKomentarjev/{stKomentarjev}")
    public List<Recept> vrniRecepteSteviloKomentarjev(@PathVariable(name="stKomentarjev") int stKomentarjev){
        return receptDao.vrniRecepteGledeNaSteviloKomentarjev(stKomentarjev);
    }

    @GetMapping("/vrniRecepteGledeNaSteviloVseckov/{stVseckov}")
    public List<Recept> vrniRecepteSteviloVseckov(@PathVariable(name="stVseckov") int stVseckov){
        return receptDao.vrniRecepteGledeNaSteviloVseckov(stVseckov);
    }



}
