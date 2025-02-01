package com.joao.API.para.encurtar.e.redireciona.URL.domain.Link.Dto;

public record LinkResponse(
        int id,
        String urlCompleta,
        String urlEncurtada
) {
}
