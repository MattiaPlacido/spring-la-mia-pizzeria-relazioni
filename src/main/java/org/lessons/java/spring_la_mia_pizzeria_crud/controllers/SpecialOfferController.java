package org.lessons.java.spring_la_mia_pizzeria_crud.controllers;

import org.lessons.java.spring_la_mia_pizzeria_crud.models.SpecialOffer;
import org.lessons.java.spring_la_mia_pizzeria_crud.repos.SpecialOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/specialOffers")
public class SpecialOfferController {

    @Autowired
    private SpecialOfferRepository repo;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("specialOffer") SpecialOffer newOffer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "specialOffers/create";
        }

        repo.save(newOffer);

        return "redirect:/pizzas";
    }

}
