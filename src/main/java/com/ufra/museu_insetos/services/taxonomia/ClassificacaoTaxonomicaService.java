package com.ufra.museu_insetos.services.taxonomia;

import com.ufra.museu_insetos.dto.request.taxonomia.FamiliaDTO;
import com.ufra.museu_insetos.dto.request.taxonomia.GeneroDTO;
import com.ufra.museu_insetos.dto.request.taxonomia.OrdemDTO;
import com.ufra.museu_insetos.query.taxonomia.ClassificacaoTaxonomicaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassificacaoTaxonomicaService {

    @Autowired
    private ClassificacaoTaxonomicaQuery classificacaoTaxonomicaQuery;

}
