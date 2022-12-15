package com.ris.projektris.controllers;


import com.ris.projektris.dao.ReceptRepository;
import com.ris.projektris.dao.UporabnikRepository;
import com.ris.projektris.dao.VprasanjeRepository;
import com.ris.projektris.dao.VsecekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.ris.projektris.models.Vsecek;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/vsecek")
public class VsecekController {

    @Autowired
    private VsecekRepository vsecekDao;

    @Autowired
    private UporabnikRepository uporabnikDao;

    @Autowired
    private ReceptRepository receptDao;


    @GetMapping("/vsi")
    public Iterable<Vsecek> vsiVsecki() {
        return vsecekDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Vsecek> vrniVsecek(@PathVariable(name="id") Long id){
        return vsecekDao.findById(id);
    }

    @DeleteMapping("/izbrisi/{id}")
    public void izbrisiVsecek(@PathVariable(name="id") Long id){
        vsecekDao.deleteById(id);
    }

    @PostMapping("/dodaj")
    public Vsecek dodajVsecek(@RequestBody Vsecek vsecek){
        return vsecekDao.save(vsecek);
    }


    @PostMapping("/dodajVsecek/{idUporabnik}/{idRecept}")
    public Optional<Vsecek> dodajVsecek(@RequestBody Vsecek vsecek, @PathVariable(name = "idUporabnik") Long idUporabnik, @PathVariable(name = "idRecept") Long idRecept ){
        uporabnikDao.findById(idUporabnik).map(uporabnik ->{
            vsecek.setUporabnik(uporabnik);
            return 0;
        });
        return receptDao.findById(idRecept).map(recept -> {
            vsecek.setRecept(recept);
            return vsecekDao.save(vsecek);
        });

    }






}



