package com.ris.projektris.controllers;

import com.ris.projektris.dao.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profil")
public class ProfilController {

    @Autowired
    private ProfilRepository profilDao;
}
