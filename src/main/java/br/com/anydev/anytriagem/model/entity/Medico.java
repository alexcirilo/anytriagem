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
public class Medico extends Pessoa{


    @Column(name = "especialidade")
    private String especialidade;

    @Column(name = "crm")
    private int CRM;

    @Column(name = "uf_crm")
    private String UF_CRM;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medico",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Consulta> listaConsultas;

    public List<Consulta> getListaConsultas() {
        if (listaConsultas == null){
            return new ArrayList<>();
        }
        return listaConsultas;
    }
}


