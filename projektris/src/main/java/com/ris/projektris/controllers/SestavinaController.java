package com.ris.projektris.controllers;

import com.ris.projektris.dao.SestavinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sestavina")
public class SestavinaController {

    @Autowired
    private SestavinaRepository sestavinaDao;
}
