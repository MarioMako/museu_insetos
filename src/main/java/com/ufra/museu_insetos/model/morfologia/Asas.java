package com.ufra.museu_insetos.model.morfologia;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ASAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Asas implements Serializable {

    private static final long serialVersionUID = -5323418028866542183L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ASAS")
    private Integer id;

    @Column(name = "TIPO_ASAS", nullable = false)
    private String tipoAsas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DESCRICAO_MORFOLOGICA", nullable = false)
    private DescricaoMorfologica descricaoMorfologica;


}
