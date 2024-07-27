package br.com.anydev.anytriagem.controller;

import br.com.anydev.anytriagem.model.dto.MedicoDto;
import br.com.anydev.anytriagem.model.dto.PacienteDto;
import br.com.anydev.anytriagem.service.MedicoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping
    public ResponseEntity<?> salvarMedico(@RequestBody MedicoDto medicoDto){
        return new ResponseEntity<>(service.save(medicoDto), HttpStatus.CREATED);
    }
}
