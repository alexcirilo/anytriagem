package br.com.anydev.anytriagem.service;

import br.com.anydev.anytriagem.exception.InternalServerException;
import br.com.anydev.anytriagem.exception.NotFoundException;
import br.com.anydev.anytriagem.model.dto.ConsultaDto;
import br.com.anydev.anytriagem.model.entity.Consulta;
import br.com.anydev.anytriagem.model.entity.Medico;
import br.com.anydev.anytriagem.model.entity.Paciente;
import br.com.anydev.anytriagem.model.entity.TipoConsultaEnum;
import br.com.anydev.anytriagem.model.mapper.ConsultaMapper;
import br.com.anydev.anytriagem.repository.ConsultaRepository;
import br.com.anydev.anytriagem.repository.MedicoRepository;
import br.com.anydev.anytriagem.repository.PacienteRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConsultaService {
    
    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private ConsultaMapper mapper;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;


    public List<ConsultaDto> findAll() {
        List<Consulta> listaConsultas = repository.findAll();
        if (listaConsultas.isEmpty()){
            throw new NotFoundException("Não há consultas marcadas");
        }
        return mapper.mapToDtoList(listaConsultas);

    }

    public ConsultaDto findById(Long id) {
        try {
            Consulta consulta = repository.findById(id).orElseThrow(()-> new NotFoundException("Consulta não encontrada"));
            return mapper.toDto(consulta);

        }catch (Exception e){
            throw new InternalServerException(e.getMessage());
        }
    }


    public List<ConsultaDto> findConsulta(TipoConsultaEnum tipoConsulta, Date horario, String medico, String paciente) {
        List<Consulta> consultas = repository.findConsulta(tipoConsulta.getId(),horario,paciente,medico);

        if (consultas.isEmpty()){
            throw new NotFoundException("Consulta não encontrada");
        }
        List<ConsultaDto> dtos = mapper.mapToDtoList(consultas);
        return dtos;
    }

    public ConsultaDto create(ConsultaDto dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPaciente().getId()).orElseThrow();
        Medico medico = medicoRepository.findById(dto.getMedico().getId()).orElseThrow();
        dto.setPaciente(paciente);
        dto.setMedico(medico);
        Consulta consulta = mapper.toEntity(dto);
        repository.save(consulta);
        dto = mapper.toDto(consulta);
        return dto ;
    }
}
