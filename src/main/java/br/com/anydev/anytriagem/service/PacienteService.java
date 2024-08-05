package br.com.anydev.anytriagem.service;

import br.com.anydev.anytriagem.exception.InternalServerException;
import br.com.anydev.anytriagem.exception.NotFoundException;
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

    public PacienteDto findById(Long id) throws Exception {
        try {
            Paciente paciente = repository.findById(id).orElseThrow(()-> new NotFoundException("Paciente não encontrado"));

            return mapper.toDto(paciente);

        }catch (Exception e){
            throw new InternalServerException(e.getMessage());
        }

    }

    public PacienteDto create(PacienteDto dto) {


        Paciente paciente = mapper.toEntity(dto);

        repository.save(paciente);

        dto = mapper.toDto(paciente);

        return dto;
    }

    public PacienteDto update(Long id, PacienteDto dto) {
        try {
            if (id != null){
                dto.setId(id);
                Paciente paciente = mapper.toEntity(dto);
                repository.save(paciente);
                return mapper.toDto(paciente);
            }
        }catch (Exception e){
            throw new InternalServerException(e.getMessage());
        }
        return null;
    }

    public void delete(Long id) throws Exception {
        try {
            if (id == null){
                throw new NotFoundException("ID não pode ser nulo");
            }
            Paciente paciente = repository.findById(id).orElseThrow(() -> new NotFoundException("Paciente não encontrado"));
            repository.delete(paciente);
        }catch (Exception e){
            throw new InternalServerException(e.getMessage());
        }


    }
}
