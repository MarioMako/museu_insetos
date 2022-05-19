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
    @JoinColumn(name = "ID_CLASSIFICAÇÃO_TAXONOMICA", nullable = false)
    private ClassificacaoTaxonomica classificacaoTaxonomica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FAMILIA", nullable = false)
    private Familia familia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return id.equals(genero.id) && nomeGenero.equals(genero.nomeGenero) && classificacaoTaxonomica.equals(genero.classificacaoTaxonomica) && familia.equals(genero.familia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeGenero, classificacaoTaxonomica, familia);
    }

}
