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

    @OneToMany(mappedBy = "classificacaoTaxonomica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Ordem> ordens;

    @OneToMany(mappedBy = "classificacaoTaxonomica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Familia> familias;

    @OneToMany(mappedBy = "classificacaoTaxonomica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Genero> generos;

    @OneToMany(mappedBy = "classificacaoTaxonomica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Especie> especies;

}