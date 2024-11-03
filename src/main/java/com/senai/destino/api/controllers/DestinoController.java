package com.senai.destino.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.destino.api.entities.Destino;
import com.senai.destino.api.services.DestinoService;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

	@Autowired
	private DestinoService destinoService;

    @PostMapping("/")
    public ResponseEntity<Destino> cadastrarDestino(@RequestBody Destino destino) {
        return destinoService.cadastrar(destino);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Destino>> listarDestinos() {
    	return destinoService.listarTodosDestinos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Destino> recuperarDestinoPorId(@PathVariable Long id) throws NotFoundException {
    	return destinoService.recuperarDestino(id);
    }
}