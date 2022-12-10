package com.ris.projektris.controllers;

import com.ris.projektris.dao.ProfilRepository;
import com.ris.projektris.dao.UporabnikRepository;
import com.ris.projektris.models.Profil;
import com.ris.projektris.models.Recept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/profil")
public class ProfilController {

    @Autowired
    private ProfilRepository profilDao;

    @Autowired
    private UporabnikRepository uporabnikDao;

    @PostMapping("/dodajProfil/{id}")
    public Optional<Profil> dodajProfil(@RequestBody Profil profil, @PathVariable(name = "id") Long id ){
        return uporabnikDao.findById(id).map(uporabnik -> {
            profil.setUporabnik(uporabnik);
            return profilDao.save(profil);
        });
    }

    @GetMapping("/iscitezastarostspolManj/{teza}/{starost}/{spol}")
    public Iterable<Profil> iscitezastarostspolManj(@PathVariable(name="teza") int teza, @PathVariable(name="starost") int starost,@PathVariable(name="spol") String spol){
        return profilDao.findBytezastarostspolManj(teza,starost,spol);
    }

    @GetMapping("/iscitezastarostspolVec/{teza}/{starost}/{spol}")
    public Iterable<Profil> iscitezastarostspolVec(@PathVariable(name="teza") int teza, @PathVariable(name="starost") int starost,@PathVariable(name="spol") String spol){
        return profilDao.findBytezastarostspolVec(teza,starost,spol);
    }


    @PutMapping("/spremeni")
        public Optional<Profil> spremeniProfil(@RequestBody Profil profil){
        profilDao.save(profil);
        return profilDao.findById(profil.getIdProfil());
    }

}
