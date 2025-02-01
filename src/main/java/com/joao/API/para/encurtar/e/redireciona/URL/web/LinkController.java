package com.joao.API.para.encurtar.e.redireciona.URL.web;

import com.joao.API.para.encurtar.e.redireciona.URL.domain.Link.Dto.LinkResponse;
import com.joao.API.para.encurtar.e.redireciona.URL.domain.Link.Link;
import com.joao.API.para.encurtar.e.redireciona.URL.domain.Link.LinkRepository;
import com.joao.API.para.encurtar.e.redireciona.URL.domain.Link.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class LinkController {

    private LinkService service;

    public LinkController(LinkService service) {
        this.service = service;
    }

    @PostMapping("/encurta")
    public ResponseEntity<LinkResponse> gerarUrlencurtada(@RequestBody Map<String, String> request) {

        String urlCompleta = request.get("urlCompleta");
        Link link = service.encurtaUrl(urlCompleta);

        String urlRedirecionamento = "http://localhost:8080/r/" + link.getUrlEncurtada();

        LinkResponse response = new LinkResponse(link.getId(), link.getUrlCompleta(), urlRedirecionamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/r/{urlEncurtada}")
    public void redirecionamentoLink(@PathVariable String urlEncurtada, HttpServletResponse response) throws IOException {

        Link link = service.obterUrlCompleta(urlEncurtada);
        if (link != null) {
            response.sendRedirect(link.getUrlCompleta());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
