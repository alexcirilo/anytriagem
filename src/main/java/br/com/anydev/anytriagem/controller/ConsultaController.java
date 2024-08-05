package br.com.anydev.anytriagem.controller;

import br.com.anydev.anytriagem.model.dto.ConsultaDto;
import br.com.anydev.anytriagem.model.entity.TipoConsultaEnum;
import br.com.anydev.anytriagem.service.ConsultaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @GetMapping("/all")
    @Operation(summary = "Buscar todas as consultas")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping
    @Operation(summary = "Buscar todas as consultas")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findConsulta(@RequestParam(required = false) @Parameter(example = "GERAL")TipoConsultaEnum tipoConsulta,
                                          @RequestParam(required = false) @Parameter @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss") Date horario,
                                          @RequestParam(required = false) @Parameter String paciente,
                                          @RequestParam(required = false) @Parameter String medico){
        return ResponseEntity.ok(service.findConsulta(tipoConsulta, horario, medico, paciente));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findById(@PathVariable(value = "id")Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody ConsultaDto dto){
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }
}
