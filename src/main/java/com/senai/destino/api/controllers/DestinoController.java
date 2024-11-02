package com.senai.destino.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.destino.api.entities.Destino;
import com.senai.destino.api.repositories.DestinoRepository;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

	@Autowired
	private DestinoRepository destinoRepository;

    @PostMapping
    public ResponseEntity<Destino> cadastrarDestino(@RequestBody Destino destino) {
        destinoRepository.save(destino);
        return ResponseEntity.ok(destino);
    }
    
}