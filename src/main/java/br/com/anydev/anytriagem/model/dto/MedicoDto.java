package br.com.anydev.anytriagem.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MedicoDto {

    private int id;
    private String nome;
    private String especialidade;
    private int CRM;
    private String UF_CRM;
    private String pesquisa;
    private String buscaMedico;
}
