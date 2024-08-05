package br.com.anydev.anytriagem.service;

import br.com.anydev.anytriagem.exception.InternalServerException;
import br.com.anydev.anytriagem.exception.NotFoundException;
import br.com.anydev.anytriagem.model.dto.MedicoDto;
import br.com.anydev.anytriagem.model.entity.Medico;
import br.com.anydev.anytriagem.model.mapper.MedicoMapper;
import br.com.anydev.anytriagem.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    @Autowired
    private MedicoMapper mapper;

    public List<MedicoDto> findAll() {
        List<MedicoDto> listaMedicos = mapper.mapToDto(repository.findAll());
        if (listaMedicos.isEmpty() || listaMedicos == null){
            throw new NotFoundException("Não possui médicos cadastrados");
        }
        return listaMedicos ;
    }

    public MedicoDto findById(Long id) {
        MedicoDto dto = mapper.toDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Médico não encontrado")));
        return dto;
    }

    public MedicoDto save(MedicoDto dto) {
        validarCampos(dto);
        try {
            Medico medico = mapper.toEntity(dto);

            repository.save(medico);

            dto = mapper.toDto(medico);
            return dto;
        }catch (Exception e){
            throw new InternalServerException(e.getMessage());
        }
    }

    public MedicoDto update(Long id, MedicoDto dto) {
        try {
            if (dto.getId() == null){
                throw new NotFoundException("ID não pode ser vazio");
            }
            return mapper.toDto(repository.save(mapper.toEntity(dto)));
        }catch (Exception e){
            throw new InternalServerException(e.getMessage());
        }
    }

    public void delete(Long id){
        if (id == null){
            throw new NotFoundException("ID não pode ser nulo");
        }
        repository.delete(repository.findById(id).orElseThrow(()-> new NotFoundException("Médico não encontrado!")));
    }


    private void validarCampos(MedicoDto dto) {
        int valorExcecaoCRM = 0;
        if (dto.getNome() == null || dto.getNome().isEmpty()){
            throw new NotFoundException("O Campo nome não pode ser vazio");
        }
        if (dto.getCpf() == null || dto.getCpf().isEmpty()){
            throw new NotFoundException("O Campo CPF não pode ser vazio");
        }
        if (dto.getEspecialidade() == null || dto.getEspecialidade().isEmpty()){
            throw new NotFoundException("O Campo especialidade não pode ser vazio");
        }
        if (dto.getCrm() <= valorExcecaoCRM){
            throw new InternalServerException("O Campo CRM não pode ter valor menor ou igual a zero");
        }
        if (dto.getUfCrm() == null || dto.getUfCrm().isEmpty()){
            throw new InternalServerException("O Campo UF_CRM precisa ser definido");
        }



    }

}
