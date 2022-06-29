package com.ufra.museu_insetos.model.morfologia;

import com.ufra.museu_insetos.model.Especie;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "DESCRICAO_MORFOLOGICA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DescricaoMorfologicaEspecie implements Serializable {

    private static final long serialVersionUID = 7201701539407049324L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DESCRICAO_MORFOLOGICA")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "ABDOMEN")
    private Abdomen abdomen;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "ANTENA")
    private Antena antena;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "APARELHO_BUCAL")
    private AparelhoBucal aparelho;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "ASAS")
    private Asas asas;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "PERNAS")
    private Pernas pernas;

}
