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
public class ClassificacaoTaxonomicaEspecie implements Serializable {


    private static final long serialVersionUID = -5778975511963912143L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLASSIFICACAO_TAXONOMICA")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "ORDEM")
    private Ordem ordem;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "FAMILIA")
    private Familia familia;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "GENERO")
    private Genero genero;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassificacaoTaxonomicaEspecie that = (ClassificacaoTaxonomicaEspecie) o;
        return Objects.equals(id, that.id) && Objects.equals(ordem, that.ordem) && Objects.equals(familia, that.familia) && Objects.equals(genero, that.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordem, familia, genero);
    }
}