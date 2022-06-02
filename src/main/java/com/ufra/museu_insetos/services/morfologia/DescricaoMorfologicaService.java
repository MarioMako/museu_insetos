package com.ufra.museu_insetos.services.morfologia;

import com.ufra.museu_insetos.query.morfologia.DescricaoMorfologicaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescricaoMorfologicaService {

    @Autowired
    private DescricaoMorfologicaQuery descricaoMorfologicaQuery;
}
