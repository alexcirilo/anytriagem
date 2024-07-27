package br.com.anydev.anytriagem.repository;

import br.com.anydev.anytriagem.model.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long>, JpaSpecificationExecutor<Paciente> {
}
