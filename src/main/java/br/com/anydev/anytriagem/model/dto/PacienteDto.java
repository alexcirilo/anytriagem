package br.com.anydev.anytriagem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class PacienteDto {

    private String nome;
    private String cpf;
    private String sexo;
    private Date dataNascimento;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String estado;
    private String pais;
    private int ddd;
    private String tipoContato;
    private String numeroContato;


}
