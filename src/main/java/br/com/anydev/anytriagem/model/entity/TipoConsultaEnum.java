package br.com.anydev.anytriagem.model.entity;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


@Getter
public enum TipoConsultaEnum {
    GERAL(1, "Geral");


    private Integer id;
    private String nome;

    private static final Map<Integer, TipoConsultaEnum> byId = new HashMap<Integer, TipoConsultaEnum>();
    static {
        for (TipoConsultaEnum e : TipoConsultaEnum.values()){
            if (byId.put(e.getId(), e) != null){
                throw new IllegalArgumentException("ID Duplicado " + e.getId());
            }
        }
    }

    TipoConsultaEnum(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public static TipoConsultaEnum getById(Integer id){
        return byId.get(id);
    }
}
