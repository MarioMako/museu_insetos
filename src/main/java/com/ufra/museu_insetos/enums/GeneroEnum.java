package com.ufra.museu_insetos.enums;

public enum GeneroEnum {
    FEMEA(0), MACHO(1);

    private Integer valor;

    private GeneroEnum(Integer genero){
        this.valor = genero;
    }
    public Integer getGenero(){
        return valor;
    }
}
