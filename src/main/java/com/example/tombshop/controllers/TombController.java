package com.example.tombshop.controllers;

import com.example.tombshop.model.Tomb;
import com.example.tombshop.repository.TombRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TombController {
    @Autowired
    private TombRepository tombRepo;


    @GetMapping("/Tombs")
    public String listAll(Model model) {
        List<Tomb> listTombs = tombRepo.findAll();
        model.addAttribute("listTombs", listTombs);

        return "Tombs";
    }
}
