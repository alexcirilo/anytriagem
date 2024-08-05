package br.com.anydev.anytriagem.model.dto;

import br.com.anydev.anytriagem.model.entity.Medico;
import br.com.anydev.anytriagem.model.entity.Paciente;
import br.com.anydev.anytriagem.model.entity.TipoConsultaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class ConsultaDto {
    private Long id;
    private TipoConsultaEnum tipoConsulta;
    private Medico medico;
    private Paciente paciente;
    private String cid;
    private Date horario;

}
