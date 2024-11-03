package com.senai.destino.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.senai.destino.api.entities.Destino;
import com.senai.destino.api.repositories.DestinoRepository;

@Service
public class DestinoService {

	@Autowired
	private DestinoRepository destinoRepository;

	public ResponseEntity<Destino> cadastrar(Destino destino) {
		Destino novoDestino = destinoRepository.save(destino);
		return new ResponseEntity<>(novoDestino, HttpStatus.CREATED);      
	}

	public ResponseEntity<List<Destino>> listarTodosDestinos() {
		List<Destino> destinos = destinoRepository.findAll();	
		return new ResponseEntity<>(destinos, HttpStatus.OK);
	}

	public ResponseEntity<Destino> recuperarDestino(Long id) throws NotFoundException {
		Destino destino = destinoRepository.findById(id).orElseThrow(() -> new NotFoundException());
		return new ResponseEntity<>(destino, HttpStatus.OK);
	}

}
