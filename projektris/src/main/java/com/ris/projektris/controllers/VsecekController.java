package com.ris.projektris.controllers;


import com.ris.projektris.dao.VprasanjeRepository;
import com.ris.projektris.dao.VsecekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vsecek")
public class VsecekController {

    @Autowired
    private VsecekRepository vsecekDao;
}
