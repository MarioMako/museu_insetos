package com.ufra.museu_insetos.model.taxonomia;

import com.ufra.museu_insetos.model.Especie;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "GENERO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Genero implements Serializable {

    private static final long serialVersionUID = -1886828522765860080L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GENERO")
    private int id;

    @Column(name = "NOME_GENERO")
    private String nomeGenero;

    @ManyToOne
    @JoinColumn(name = "ID_FAMILIA", nullable = false)
    private Familia familia;

    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Especie> especies;


}
