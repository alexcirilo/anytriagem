package br.com.anydev.anytriagem.model.dto;

import br.com.anydev.anytriagem.model.entity.Consulta;
import br.com.anydev.anytriagem.model.entity.Contato;
import br.com.anydev.anytriagem.model.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MedicoDto {

    private Long id;
    private String nome;
    private String cpf;
    private String sexo;
    private LocalDate dataNascimento;
    private String especialidade;
    private int crm;
    private String ufCrm;



}
