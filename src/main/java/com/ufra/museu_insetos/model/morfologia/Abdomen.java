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
    private Integer id;

    @Column(name = "TIPO_ABDOMEN", nullable = false)
    private String tipoAbdomen;

}
