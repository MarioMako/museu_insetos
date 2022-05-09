package com.ufra.museu_insetos.model.taxonomia;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "GENERO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Genero implements Serializable {

    private static final long serialVersionUID = -1886828522765860080L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GENERO")
    private Integer id;

    @Column(name = "NOME_GENERO")
    private String nomeGenero;

    @ManyToOne
    @JoinColumn(name = "ID_CLASSIFICAÇÃO_TAXONOMICA", nullable = false)
    private ClassificacaoTaxonomica classificacaoTaxonomica;

    @ManyToOne
    @JoinColumn(name = "ID_FAMILIA", nullable = false)
    private Familia familia;

}
