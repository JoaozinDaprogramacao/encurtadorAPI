package com.joao.API.para.encurtar.e.redireciona.URL.domain.Link;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

   private LinkRepository repository;

   public LinkService(LinkRepository repository) {
       this.repository = repository;
   }

   public String geraUrlAleatoria() {
       return RandomStringUtils.randomAlphanumeric(5,10);
   }

   public Link encurtaUrl(String urlOriginal) {
       return repository.save(new Link(urlOriginal, geraUrlAleatoria()));
   }

    public Link obterUrlCompleta(String urlEncurtada) {
        Link link = repository.findByUrlEncurtada(urlEncurtada);

        if (link == null) {
            throw new RuntimeException("URL não encontrada nos registros.");
        }

        return link;
    }


}
