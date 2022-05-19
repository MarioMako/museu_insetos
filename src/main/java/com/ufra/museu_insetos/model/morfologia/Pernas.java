package com.ufra.museu_insetos.model.morfologia;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERNAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pernas implements Serializable {

    private static final long serialVersionUID = -5924240335474814095L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERNAS")
    private Integer id;

    @Column(name = "TIPO_PERNAS", nullable = false)
    private String tipoPernas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DESCRICAO_MORFOLOGICA", nullable = false)
    private DescricaoMorfologica descricaoMorfologica;


}
