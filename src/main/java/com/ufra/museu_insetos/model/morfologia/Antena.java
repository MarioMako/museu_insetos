package com.ufra.museu_insetos.model.morfologia;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ANTENA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Antena implements Serializable {

    private static final long serialVersionUID = 4685179000935636882L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ANTENA")
    private Integer id;

    @Column(name = "TIPO_ANTENA", nullable = false)
    private String tipoAntena;

}
