package com.ufra.museu_insetos.model.taxonomia;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import com.ufra.museu_insetos.model.Especie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "ORDEM"
)

@Getter
@Setter
public class Ordem extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_ORDEM"
    )
    private int id;

    @Column(
            name = "NOME"
    )
    private String nome;

    @ManyToOne
    @JoinColumn(name="ID_CLASSIFICACAO_TAXONOMICA",nullable = false)
    private ClassificacaoTaxonomica classificacaoTaxonomica_id;

    @OneToMany(mappedBy="ordem", fetch = FetchType.LAZY)
    private List<Familia> familias;

    @OneToMany(mappedBy="ordem", fetch = FetchType.LAZY)
    private List<Especie> especies;

    public Ordem() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}