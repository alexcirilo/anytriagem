package br.com.anydev.anytriagem.model.mapper;

import br.com.anydev.anytriagem.model.dto.ConsultaDto;
import br.com.anydev.anytriagem.model.entity.Consulta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    ConsultaMapper INSTANCE = Mappers.getMapper(ConsultaMapper.class);

    Consulta toEntity(ConsultaDto dto);

    ConsultaDto toDto(Consulta consulta);

    List<ConsultaDto> mapToDtoList(List<Consulta> consultas);
}
