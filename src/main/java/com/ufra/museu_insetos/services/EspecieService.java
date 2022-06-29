package com.ufra.museu_insetos.services;

import com.ufra.museu_insetos.dto.request.CuriosidadeDTO;
import com.ufra.museu_insetos.dto.request.EspecieDTO;
import com.ufra.museu_insetos.model.Especie;
import com.ufra.museu_insetos.model.ecologica.HabitatEnum;
import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologicaEspecie;
import com.ufra.museu_insetos.model.taxonomia.ClassificacaoTaxonomicaEspecie;
import com.ufra.museu_insetos.query.EspecieQuery;
import com.ufra.museu_insetos.query.biologica.MetamorfoseQuery;
import com.ufra.museu_insetos.query.ecologia.ComportamentoQuery;
import com.ufra.museu_insetos.query.morfologia.*;
import com.ufra.museu_insetos.query.taxonomia.ClassificacaoTaxonomicaQuery;
import com.ufra.museu_insetos.query.taxonomia.FamiliaQuery;
import com.ufra.museu_insetos.query.taxonomia.GeneroQuery;
import com.ufra.museu_insetos.query.taxonomia.OrdemQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EspecieService {

    @Autowired
    private EspecieQuery especieQuery;
    @Autowired
    private ComportamentoQuery comportamentoQuery;
    @Autowired
    private MetamorfoseQuery metamorfoseQuery;
    @Autowired
    private ClassificacaoTaxonomicaQuery classificacaoTaxonomicaQuery;
    @Autowired
    private DescricaoMorfologicaQuery descricaoMorfologicaQuery;
    @Autowired
    private OrdemQuery ordemQuery;
    @Autowired
    private FamiliaQuery familiaQuery;
    @Autowired
    private GeneroQuery generoQuery;
    @Autowired
    private AbdomenQuery abdomenQuery;
    @Autowired
    private AntenaQuery antenaQuery;
    @Autowired
    private AparelhoBucalQuery aparelhoBucalQuery;
    @Autowired
    private AsasQuery asasQuery;
    @Autowired
    private PernasQuery pernasQuery;

    public EspecieDTO salvarEspecie(EspecieDTO especiedto) {
        Especie especie = new Especie();

        especie.setNomeVulgar(especiedto.getNomeVulgar());
        especie.setNomeCientifico(especiedto.getNomeCientifico());
        especie.setUrlImagem(especiedto.getUrlImagem());
        especie.setDescricaoLivre(especiedto.getDescricaoLivre());
        especie.setHabitat(especiedto.getHabitat());

        especie.setComportamento(comportamentoQuery.findById(especiedto.getComportamento().getId()).orElseThrow());
        especie.setMetamorfose(metamorfoseQuery.findById(especiedto.getMetamorfose().getId()).orElseThrow());

        var c = classificacaoTaxonomicaQuery.findFiltros(especiedto.getClassificacaoTaxonomica().getOrdem().getId(),
                                                                                            especiedto.getClassificacaoTaxonomica().getFamilia().getId(),
                                                                                            especiedto.getClassificacaoTaxonomica().getGenero().getId());
        var d = descricaoMorfologicaQuery.getFiltros(especiedto.getDescricaoMorfologica().getAbdomen().getId(),
                                                                                     especiedto.getDescricaoMorfologica().getAntena().getId(),
                                                                                    especiedto.getDescricaoMorfologica().getAparelhoBucal().getId(),
                                                                                    especiedto.getDescricaoMorfologica().getAsas().getId(),
                                                                                    especiedto.getDescricaoMorfologica().getPernas().getId());

        if(c ==  null){
            c = new ClassificacaoTaxonomicaEspecie();
            c.setOrdem(ordemQuery.findById(especiedto.getClassificacaoTaxonomica().getId()).orElseThrow());
            c.setFamilia(familiaQuery.findById(especiedto.getClassificacaoTaxonomica().getId()).orElseThrow());
            c.setGenero(generoQuery.findById(especiedto.getClassificacaoTaxonomica().getId()).orElseThrow());
            classificacaoTaxonomicaQuery.save(c);
        }
        if(d == null){
            d = new DescricaoMorfologicaEspecie();
            d.setAbdomen(abdomenQuery.findById(especiedto.getDescricaoMorfologica().getId()).orElseThrow());
            d.setAntena(antenaQuery.findById(especiedto.getDescricaoMorfologica().getId()).orElseThrow());
            d.setAparelho(aparelhoBucalQuery.findById(especiedto.getDescricaoMorfologica().getId()).orElseThrow());
            d.setAsas(asasQuery.findById(especiedto.getDescricaoMorfologica().getId()).orElseThrow());
            d.setPernas(pernasQuery.findById(especiedto.getDescricaoMorfologica().getId()).orElseThrow());
            descricaoMorfologicaQuery.save(d);
        }

        especie.setClassificacaoTaxonomicaEspecie(c);
        especie.setDescricaoMorfologicaEspecie(d);

        var res = especieQuery.save(especie);
        return new EspecieDTO(res);
    }

    public EspecieDTO obterEspeciePorId(Integer id){
        var res = especieQuery.findById(id).orElseThrow(() -> new NotFoundException("Espécie não encontrada.".replace("id",id.toString())));
        return new EspecieDTO(res);
    }

    public void excluirEspecie(Integer id){
        var res = especieQuery.findById(id).orElseThrow(() -> new NotFoundException("Espécie não encontrada.".replace("id",id.toString())));
        especieQuery.delete(res);
    }

    public List<EspecieDTO> getAllEspecies(){
        List<EspecieDTO> especies = new ArrayList<EspecieDTO>();
        especies = StreamSupport.stream(especieQuery.findAll().spliterator(),false).map(EspecieDTO::new).collect(Collectors.toList());
        return especies;
    }

    public Especie atualizarEspecie(EspecieDTO especiedto){
        Especie especie = especieQuery.findById(especiedto.getId()).orElseThrow();

        especie.setNomeVulgar(especiedto.getNomeVulgar());
        especie.setNomeCientifico(especiedto.getNomeCientifico());
        especie.setHabitat(especiedto.getHabitat());
        especie.setDescricaoLivre(especiedto.getDescricaoLivre());
        especie.setUrlImagem(especiedto.getUrlImagem());

        especie.setComportamento(comportamentoQuery.findById(especiedto.getComportamento().getId()).orElseThrow());
        especie.setMetamorfose(metamorfoseQuery.findById(especiedto.getMetamorfose().getId()).orElseThrow());

        var c = classificacaoTaxonomicaQuery.findFiltros(especiedto.getClassificacaoTaxonomica().getOrdem().getId(),
                especiedto.getClassificacaoTaxonomica().getFamilia().getId(),
                especiedto.getClassificacaoTaxonomica().getGenero().getId());
        var d = descricaoMorfologicaQuery.getFiltros(especiedto.getDescricaoMorfologica().getAbdomen().getId(),
                especiedto.getDescricaoMorfologica().getAntena().getId(),
                especiedto.getDescricaoMorfologica().getAparelhoBucal().getId(),
                especiedto.getDescricaoMorfologica().getAsas().getId(),
                especiedto.getDescricaoMorfologica().getPernas().getId());

        if(c ==  null){
            c = new ClassificacaoTaxonomicaEspecie();
            c.setOrdem(ordemQuery.findById(especiedto.getClassificacaoTaxonomica().getId()).orElseThrow());
            c.setFamilia(familiaQuery.findById(especiedto.getClassificacaoTaxonomica().getId()).orElseThrow());
            c.setGenero(generoQuery.findById(especiedto.getClassificacaoTaxonomica().getId()).orElseThrow());
            classificacaoTaxonomicaQuery.save(c);
        }
        if(d == null){
            d = new DescricaoMorfologicaEspecie();
            d.setAbdomen(abdomenQuery.findById(especiedto.getDescricaoMorfologica().getId()).orElseThrow());
            d.setAntena(antenaQuery.findById(especiedto.getDescricaoMorfologica().getId()).orElseThrow());
            d.setAparelho(aparelhoBucalQuery.findById(especiedto.getDescricaoMorfologica().getId()).orElseThrow());
            d.setAsas(asasQuery.findById(especiedto.getDescricaoMorfologica().getId()).orElseThrow());
            d.setPernas(pernasQuery.findById(especiedto.getDescricaoMorfologica().getId()).orElseThrow());
            descricaoMorfologicaQuery.save(d);
        }

        especie.setClassificacaoTaxonomicaEspecie(c);
        especie.setDescricaoMorfologicaEspecie(d);

        return especieQuery.save(especie);
    }

    public List<EspecieDTO> pesquisaEspecie(String nome, Integer ordem, Integer familia, Integer genero, Integer abdomen, Integer antena, Integer aparelho,
                                            Integer asas, Integer pernas, Integer comportamento, Integer metamorfose, HabitatEnum habitat){
        var res = especieQuery.findAllByFiltros(nome,ordem, familia, genero, abdomen, antena, aparelho, asas, pernas, comportamento, metamorfose, habitat);
        List<EspecieDTO> dtos = new ArrayList<>();

        res.forEach(especie -> {
            EspecieDTO dto = new EspecieDTO(especie);
            dtos.add(dto);
        });

        return dtos;
    }




}
