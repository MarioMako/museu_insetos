package com.ufra.museu_insetos.model.morfologia;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import com.ufra.museu_insetos.model.Especie;
import com.ufra.museu_insetos.model.taxonomia.Ordem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "DESCRICAO_MORFOLOGICA"
)

@Getter
@Setter
public class DescricaoMorfologica extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_DESCRICAO_MORFOLOGICA"
    )
    private int id;

    @Column(
            name = "TIPO"
    )
    private String tipo;

    @OneToMany(mappedBy="descricao_morfologica", fetch = FetchType.LAZY)
    private List<Antena> antenas;

    @OneToMany(mappedBy="descricao_morfologica", fetch = FetchType.LAZY)
    private List<Asas> asasList;

    @OneToMany(mappedBy="descricao_morfologica", fetch = FetchType.LAZY)
    private List<Abdomen> abdomens;

    @OneToMany(mappedBy="descricao_morfologica", fetch = FetchType.LAZY)
    private List<AparelhoBucal> aparelhoBucais;

    @OneToMany(mappedBy="descricao_morfologica", fetch = FetchType.LAZY)
    private List<Pernas> pernasList;

    @OneToMany(mappedBy="classificacao_taxonomica", fetch = FetchType.LAZY)
    private List<Especie> especies;

    public DescricaoMorfologica() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
