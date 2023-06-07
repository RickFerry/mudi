package br.com.study.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.study.mudi.config.Interceptor;
import br.com.study.mudi.config.Interceptor.Acesso;

@RestController
@RequestMapping("acessos")
public class AcessosRest {
    
    @GetMapping
    public List<Acesso> getAcessos(){
        return Interceptor.acessos;
    }
}
