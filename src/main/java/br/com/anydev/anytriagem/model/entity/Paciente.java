package br.com.anydev.anytriagem.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "pacientes_enderecos", joinColumns = @JoinColumn(name = "paciente_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private List<Endereco> listaEnderecos ;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "pacientes_contatos", joinColumns = @JoinColumn(name = "paciente_id"), inverseJoinColumns = @JoinColumn(name = "contato_id"))
    private List<Contato> listaContatos ;


    public List<Contato> getListaContatos() {
        if (listaContatos == null){
            return new ArrayList<>();
        }
        return listaContatos;
    }

    public List<Endereco> getListaEnderecos() {
        if (listaEnderecos == null){
            return new ArrayList<>();
        }
        return listaEnderecos;
    }

    public List<Consulta> getListaConsultas() {
        if (listaConsultas == null){
            return new ArrayList<>();
        }
        return listaConsultas;
    }
}
