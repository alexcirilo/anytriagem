package br.com.anydev.anytriagem.controller;

import br.com.anydev.anytriagem.model.dto.MedicoDto;
import br.com.anydev.anytriagem.model.dto.PacienteDto;
import br.com.anydev.anytriagem.service.MedicoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicoDto findByIdMedico(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(service.findById(id)).getBody();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> salvaMedico(@RequestBody MedicoDto medicoDto){
        return new ResponseEntity<>(service.save(medicoDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> atualizaMedico(@PathVariable(value = "id") Long id,
                                          @RequestBody MedicoDto medicoDto){
        return new ResponseEntity<>(service.update(id, medicoDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedico(@PathVariable(value = "id") Long id){
        service.delete(id);
    }
}
