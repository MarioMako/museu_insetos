package com.ufra.museu_insetos.model.taxonomia;

import com.ufra.museu_insetos.model.Especie;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLASSIFICACAO_TAXONOMICA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClassificacaoTaxonomica implements Serializable {


    private static final long serialVersionUID = -5778975511963912143L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLASSIFICACAO_TAXONOMICA")
    private Integer id;

    @Column(name = "TIPO_CLASSIFICACAO_TAXONOMICA", nullable = false)
    private String tipoClassificacaoTaxonomica;

    @OneToMany(mappedBy = "classificacaoTaxonomica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Ordem> ordens;

    @OneToMany(mappedBy = "classificacaoTaxonomica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Familia> familias;

    @OneToMany(mappedBy = "classificacaoTaxonomica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Genero> generos;

    @OneToMany(mappedBy = "classificacaoTaxonomica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Especie> especies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassificacaoTaxonomica that = (ClassificacaoTaxonomica) o;
        return id.equals(that.id) && tipoClassificacaoTaxonomica.equals(that.tipoClassificacaoTaxonomica) && ordens.equals(that.ordens) && familias.equals(that.familias) && generos.equals(that.generos) && especies.equals(that.especies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoClassificacaoTaxonomica, ordens, familias, generos, especies);
    }


}