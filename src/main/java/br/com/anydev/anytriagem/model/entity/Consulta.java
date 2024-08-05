package br.com.anydev.anytriagem.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipoConsulta")
    private TipoConsultaEnum tipoConsulta;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @Column(name = "cid")
    private String cid;

    @Column(name = "horario")
    private Date horario;


}
