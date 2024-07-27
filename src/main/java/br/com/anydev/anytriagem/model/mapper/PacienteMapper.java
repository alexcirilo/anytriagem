package br.com.anydev.anytriagem.model.mapper;

import br.com.anydev.anytriagem.model.dto.PacienteDto;
import br.com.anydev.anytriagem.model.entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    PacienteDto toDto(Paciente paciente);

    Paciente toEntity(PacienteDto dto);
}
