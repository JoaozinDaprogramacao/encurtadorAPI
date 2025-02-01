package com.joao.API.para.encurtar.e.redireciona.URL.domain.Link;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {

    Link findByUrlEncurtada(String urlEncurtada);


}
