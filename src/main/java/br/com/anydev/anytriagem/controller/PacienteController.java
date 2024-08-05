package br.com.anydev.anytriagem.controller;

import br.com.anydev.anytriagem.model.dto.PacienteDto;
import br.com.anydev.anytriagem.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "busca todos os pacientes")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Busca o paciente pelo ID")
    public ResponseEntity<?> findById(@PathVariable @Parameter(example = "01") Long id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Cadastra o paciente")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody PacienteDto dto){
        PacienteDto pacienteDto = service.create(dto);
        return new ResponseEntity<>(pacienteDto,HttpStatus.CREATED);
    }
    @Operation(summary = "Atualiza o paciente")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PacienteDto dto) throws Exception {
        PacienteDto pacienteDto = service.update(id, dto);
        return new ResponseEntity<>(pacienteDto,HttpStatus.CREATED);
    }

    @Operation(summary = "remove o paciente")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") Long id) throws Exception {
        service.delete(id);
    }
}
