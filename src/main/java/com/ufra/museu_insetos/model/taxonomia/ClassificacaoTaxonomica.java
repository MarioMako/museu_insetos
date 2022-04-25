package com.ufra.museu_insetos.model.taxonomia;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import com.ufra.museu_insetos.model.Especie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "CLASSIFICACAO_TAXONOMICA"
)

@Getter
@Setter
public class ClassificacaoTaxonomica extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_CLASSIFICACAO_TAXONOMICA"
    )
    private int id;

    @Column(
            name = "TIPO"
    )
    private String tipo;

    @OneToMany(mappedBy="classificacao_taxonomica", fetch = FetchType.LAZY)
    private List<Ordem> ordens;

    @OneToMany(mappedBy="classificacao_taxonomica", fetch = FetchType.LAZY)
    private List<Especie> especies;

    public ClassificacaoTaxonomica() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}