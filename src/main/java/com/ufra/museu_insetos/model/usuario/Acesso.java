package com.ufra.museu_insetos.model.usuario;

import javax.persistence.*;
import br.com.wpe.api.persistence.bean.AbstractEntity;
import com.ufra.museu_insetos.model.taxonomia.Genero;
import com.ufra.museu_insetos.model.taxonomia.Ordem;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
    @Table(
         name = "ACESSO"
    )

public class Acesso extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_ACESSO",
            nullable = false
    )
    private int id;

    @Getter
    @Setter
    @Column(
            name = "DATAHORA"
    )
    private LocalDateTime datahora;

    @Getter
    @Setter
    @Column(
            name = "IP"
    )
    private String ip;

    @ManyToOne
    @JoinColumn(name="ID_USUARIO",nullable = false)
    private Usuario usuario_id;

    public Acesso() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }



}

