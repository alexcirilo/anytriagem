package br.com.anydev.anytriagem.model.dto;

import br.com.anydev.anytriagem.model.entity.Consulta;
import br.com.anydev.anytriagem.model.entity.Contato;
import br.com.anydev.anytriagem.model.entity.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class PacienteDto {

    private Long id;
    private String nome;
    private String cpf;
    private String sexo;
    private LocalDate dataNascimento;
    private List<Endereco> listaEnderecos;
    private List<Contato> listaContatos;
    private List<Consulta> listaConsultas;



}
