package br.com.anydev.anytriagem.model.mapper;

import br.com.anydev.anytriagem.model.dto.MedicoDto;
import br.com.anydev.anytriagem.model.entity.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);


    Medico toEntity(MedicoDto dto);

    MedicoDto toDto(Medico medico);

    List<MedicoDto> mapToDto(List<Medico> medicos);

}
