package com.ufra.museu_insetos.model.morfologia;

import com.ufra.museu_insetos.model.Especie;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DESCRICAO_MORFOLOGICA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DescricaoMorfologica implements Serializable {

    private static final long serialVersionUID = 7201701539407049324L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DESCRICAO_MORFOLOGICA")
    private Integer id;

    @Column(name = "TIPO_DESCRICAO_MORFOLOGICA", nullable = false)
    private String tipoDescricaoMorfologica;

    @OneToMany(mappedBy = "descricaoMorfologica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Antena> antenas;

    @OneToMany(mappedBy = "descricaoMorfologica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Asas> asasList;

    @OneToMany(mappedBy = "descricaoMorfologica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Abdomen> abdomens;

    @OneToMany(mappedBy = "descricaoMorfologica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<AparelhoBucal> aparelhoBucais;

    @OneToMany(mappedBy = "descricaoMorfologica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Pernas> pernasList;

    @OneToMany(mappedBy = "descricaoMorfologica", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Especie> especies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescricaoMorfologica that = (DescricaoMorfologica) o;
        return id.equals(that.id) && tipoDescricaoMorfologica.equals(that.tipoDescricaoMorfologica) && antenas.equals(that.antenas) && asasList.equals(that.asasList) && abdomens.equals(that.abdomens) && aparelhoBucais.equals(that.aparelhoBucais) && pernasList.equals(that.pernasList) && especies.equals(that.especies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoDescricaoMorfologica, antenas, asasList, abdomens, aparelhoBucais, pernasList, especies);
    }

}
