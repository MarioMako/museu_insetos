package com.ufra.museu_insetos.model.usuario;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
@Entity
@Table(
        name = "USUARIO"
)

@Getter
@Setter
public class Usuario extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_USUARIO"
    )
    private int id;

    @Column(
            name = "NOME"
    )
    private String nome;

    @CPF
    @Column(
            name = "CPF"
    )
    private String cpf;

    @Column(
            name = "LOGIN"
    )
    private String login;

    

    public Usuario() {
    }
    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
