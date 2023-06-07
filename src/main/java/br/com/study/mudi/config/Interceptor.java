package br.com.study.mudi.config;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.Data;

public class Interceptor extends HandlerInterceptorAdapter {

    public static List<Acesso> acessos = new ArrayList<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Acesso acesso = new Acesso();
        acesso.setPath(request.getRequestURI());
        acesso.setData(LocalDateTime.now());
        request.setAttribute("acesso", acesso);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        Acesso acesso = (Acesso) request.getAttribute("acesso");
        acesso.setDuracao(Duration.between(acesso.getData(), LocalDateTime.now()));
        acessos.add(acesso);
    }

    @Data
    public static class Acesso {
        String path;
        LocalDateTime data;
        Duration duracao;
    }
}
