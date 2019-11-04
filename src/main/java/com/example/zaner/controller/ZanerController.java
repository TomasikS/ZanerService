/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.zaner.controller;

import com.example.zaner.model.Database;
import com.example.zaner.model.Zaner;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author stefan.tomasik
 */
@RestController
@RequestMapping("/api")
public class ZanerController {

    @Autowired
    Database zanerRepository;

    @GetMapping("/notes")
    public List<Zaner> getAllNotes() {
        return zanerRepository.findAll();
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer zanerID) {
        Zaner zaner;
        zaner = getZanerById(zanerID);
        zanerRepository.delete(zaner);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/notes")
    public Zaner createNote(@Valid @RequestBody Zaner zaner) {
        return zanerRepository.save(zaner);
    }

    @GetMapping("/notes/{id}")
    public Zaner getZanerById(@PathVariable(value = "id") Integer zanerID) {

        return zanerRepository.findById(zanerID)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Note");
                });

    }

}
