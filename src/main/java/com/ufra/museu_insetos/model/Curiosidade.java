package com.ufra.museu_insetos.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CURIOSIDADE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Curiosidade implements Serializable {

    private static final long serialVersionUID = -6119795451474754909L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CURIOSIDADE")
    private Integer id;

    @Column(name = "TITULO", nullable = false, unique = true)
    private String titulo;

    @Column(name = "DESCRICAO", nullable = false, unique = false)
    private Long descricao;

}
