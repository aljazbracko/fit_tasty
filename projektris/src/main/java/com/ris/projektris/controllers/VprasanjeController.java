package com.ris.projektris.controllers;

import com.ris.projektris.dao.VprasanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vprasanje")
public class VprasanjeController {

    @Autowired
    private VprasanjeRepository vprasanjeDao;
}
