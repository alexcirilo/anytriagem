package br.com.anydev.anytriagem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@EqualsAndHashCode(callSuper = true)
public class Paciente extends Pessoa{

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "paciente",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Consulta> listaConsultas;


    public List<Consulta> getListaConsulta() {
        if (listaConsultas == null){
            return new ArrayList<>();
        }
        return listaConsultas;
    }
}
