package com.ris.projektris.controllers;

import com.ris.projektris.dao.KomentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/komentar")
public class KomentarController {

    @Autowired
    private KomentarRepository komentarDao;
}
