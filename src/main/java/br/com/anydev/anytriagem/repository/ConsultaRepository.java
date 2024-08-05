package br.com.anydev.anytriagem.repository;

import br.com.anydev.anytriagem.model.entity.Consulta;
import br.com.anydev.anytriagem.model.entity.TipoConsultaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>, JpaSpecificationExecutor<Consulta> {

    @Query(value = "select u from Consulta u where " +
            "u.tipoConsulta = :tipoConsulta or " +
            "u.horario = :horario or " +
            "u.medico.nome = :medico or " +
            "u.paciente.nome = :paciente")
    List<Consulta> findConsulta(Integer tipoConsulta, Date horario, String paciente, String medico);
}
