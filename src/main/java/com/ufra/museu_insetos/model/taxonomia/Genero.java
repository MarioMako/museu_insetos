package com.ufra.museu_insetos.model.taxonomia;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "GENERO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Genero implements Serializable {


    private static final long serialVersionUID = -7676134974705220044L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GENERO")
    private Integer id;

    @Column(name = "NOME_GENERO", nullable = false)
    private String nomeGenero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FAMILIA", nullable = false)
    private Familia familia;


}
