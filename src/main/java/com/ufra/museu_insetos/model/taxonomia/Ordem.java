package com.ufra.museu_insetos.model.taxonomia;

import com.ufra.museu_insetos.model.Especie;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ORDEM")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ordem implements Serializable {

    private static final long serialVersionUID = 8247601731927291134L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ORDEM")
    private Integer id;

    @Column(name = "NOME_ORDEM", nullable = false)
    private String nomeOrdem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLASSIFICACAO_TAXONOMICA", nullable = false)
    private ClassificacaoTaxonomica classificacaoTaxonomica;

    @OneToMany(mappedBy = "ordem", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Familia> familias;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ordem ordem = (Ordem) o;
        return id.equals(ordem.id) && nomeOrdem.equals(ordem.nomeOrdem) && classificacaoTaxonomica.equals(ordem.classificacaoTaxonomica) && familias.equals(ordem.familias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeOrdem, classificacaoTaxonomica, familias);
    }

}