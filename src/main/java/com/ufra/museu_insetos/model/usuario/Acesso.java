package com.ufra.museu_insetos.model.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ACESSO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Acesso implements Serializable {

    private static final long serialVersionUID = -2381112246841394546L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ACESSO")
    private Long id;

    @Column(name = "DATAHORA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datahora;

    @Column(name = "IP", nullable = false)
    private String ip;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false, unique = true)
    private Usuario usuario;


}

