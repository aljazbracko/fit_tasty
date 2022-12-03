package com.ris.projektris.controllers;

import com.ris.projektris.dao.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specialist")
public class SpecialistController {

    @Autowired
    private SpecialistRepository specialistDao;
}
