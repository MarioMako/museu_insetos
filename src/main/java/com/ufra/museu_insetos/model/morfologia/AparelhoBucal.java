package com.ufra.museu_insetos.model.morfologia;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "APARELHO_BUCAL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AparelhoBucal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_APARELHO_BUCAL")
    private Long id;

    @Column(name = "TIPO_APARELHOBUCAL", nullable = false)
    private String tipoAparalhoBucal;

    @ManyToOne
    @JoinColumn(name = "ID_DESCRICAO_MORFOLOGICA", nullable = false)
    private DescricaoMorfologica descricaoMorfologica;


}
