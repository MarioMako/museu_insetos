package com.ufra.museu_insetos.model.ecologica;

public enum HabitatEnum {
    AMBOS(0), TERRESTRE(1), AQUATICO(2);

    private Integer valor;

    private HabitatEnum(Integer habitat){
        this.valor = habitat;
    }

    public Integer getHabitat(){
        return valor;
    }
}
