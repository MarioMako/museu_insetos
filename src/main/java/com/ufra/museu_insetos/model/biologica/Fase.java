package com.ufra.museu_insetos.model.biologica;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FASE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FASE")
    private Integer id;

    @Column(name = "DESCRICAO_FASE", nullable = false)
    private String descricaoFase;

    @Column(name = "TEMPO_FASE", nullable = false)
    private String tempoFase;

    @ManyToOne
    @JoinColumn(name = "ID_METAMORFOSE", nullable = false)
    private Metamorfose metamorfose;


}
