package br.com.anydev.anytriagem.service;

import br.com.anydev.anytriagem.model.dto.PacienteDto;
import br.com.anydev.anytriagem.model.entity.Contato;
import br.com.anydev.anytriagem.model.entity.Endereco;
import br.com.anydev.anytriagem.model.entity.Paciente;
import br.com.anydev.anytriagem.model.entity.Pessoa;
//import br.com.anydev.anytriagem.model.mapper.PacienteMapper;
import br.com.anydev.anytriagem.model.mapper.PacienteMapper;
import br.com.anydev.anytriagem.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Autowired
    private PacienteMapper mapper;

    public List<Paciente> findAll() {
        return repository.findAll();
    }

    public Paciente findById(Long id) throws Exception {
        try {
            return repository.findById(id).orElseThrow(()-> new Exception("Paciente não encontrado"));

        }catch (Exception e){
            throw new Exception(e);
        }

    }

    public PacienteDto create(PacienteDto dto) {

        Paciente paciente = mapper.toEntity(dto);

        repository.save(paciente);

        dto = mapper.toDto(paciente);

        return dto;
    }
}
