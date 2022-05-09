package com.ufra.museu_insetos.model.taxonomia;

import com.ufra.museu_insetos.model.Especie;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "ID_CLASSIFICACAO_TAXONOMICA", nullable = false)
    private ClassificacaoTaxonomica classificacaoTaxonomica;

    @OneToMany(mappedBy = "ordem", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Familia> familias;

}