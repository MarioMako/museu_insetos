package com.ufra.museu_insetos.model.taxonomia;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "FAMILIA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Familia implements Serializable {


    private static final long serialVersionUID = -7676134974705220044L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FAMILIA")
    private Integer id;

    @Column(name = "NOME_FAMILIA", nullable = false)
    private String nomeFamilia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLASSIFICAÇÃO_TAXONOMICA", nullable = false)
    private ClassificacaoTaxonomica classificacaoTaxonomica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ORDEM", nullable = false)
    private Ordem ordem;

    @OneToMany(mappedBy = "familia", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Genero> generos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Familia familia = (Familia) o;
        return id.equals(familia.id) && nomeFamilia.equals(familia.nomeFamilia) && classificacaoTaxonomica.equals(familia.classificacaoTaxonomica) && ordem.equals(familia.ordem) && generos.equals(familia.generos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeFamilia, classificacaoTaxonomica, ordem, generos);
    }

}
