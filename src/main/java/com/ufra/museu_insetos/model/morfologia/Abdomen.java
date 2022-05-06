package com.ufra.museu_insetos.model.morfologia;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ABDOMEN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Abdomen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ANTENA")
    private Long id;

    @Column(name = "TIPO_ABDOMEN", nullable = false)
    private String tipoAbdomen;

    @ManyToOne
    @JoinColumn(name = "ID_DESCRICAO_MORFOLOGICA", nullable = false)
    private DescricaoMorfologica descricaoMorfologica;


}
