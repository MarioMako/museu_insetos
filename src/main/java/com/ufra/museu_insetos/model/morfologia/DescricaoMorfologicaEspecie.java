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
public class DescricaoMorfologicaEspecie implements Serializable {

    private static final long serialVersionUID = 7201701539407049324L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DESCRICAO_MORFOLOGICA_ESPECIE")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "ABDOMEN")
    private Abdomen abdomen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ANTENA")
    private Antena antena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APARELHO_BUCAL")
    private AparelhoBucal aparelho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASAS")
    private Asas asas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERNAS")
    private Pernas pernas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescricaoMorfologicaEspecie that = (DescricaoMorfologicaEspecie) o;
        return Objects.equals(id, that.id) && Objects.equals(abdomen, that.abdomen) && Objects.equals(antena, that.antena) && Objects.equals(aparelho, that.aparelho) && Objects.equals(asas, that.asas) && Objects.equals(pernas, that.pernas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, abdomen, antena, aparelho, asas, pernas);
    }
}
