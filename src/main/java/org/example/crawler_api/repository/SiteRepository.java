package org.example.crawler_api.repository;

import org.example.crawler_api.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface SiteRepository extends JpaRepository<Site, Long> {

}
