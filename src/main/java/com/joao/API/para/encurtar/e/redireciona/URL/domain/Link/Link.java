package com.joao.API.para.encurtar.e.redireciona.URL.domain.Link;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "link")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "url_completa")
    private String urlCompleta;

    @Column(name = "url_encurtada")
    private String urlEncurtada;

    public Link(String urlCompleta, String urlEncurtada) {
        this.urlCompleta = urlCompleta;
        this.urlEncurtada = urlEncurtada;
    }
}
