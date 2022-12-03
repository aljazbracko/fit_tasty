package com.ris.projektris.controllers;

import com.ris.projektris.dao.OdgovorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/odgovor")
public class OdgovorController {

    @Autowired
    private OdgovorRepository odgovorDao;
}
