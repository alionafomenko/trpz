package org.example.project.repository;


import org.example.project.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SiteRepository extends JpaRepository<Site, Long> {

    @Query(value = "SELECT * FROM trpz.get_all_sites()", nativeQuery = true)
    List<Site> getAllSites();

    @Query(value = "SELECT * FROM trpz.get_all_sites_for_admin()", nativeQuery = true)
    List<Site> getAllSitesForAdmin();

    @Query(value = "SELECT * FROM trpz.add_site(?1, ?2)", nativeQuery = true)
    String addSite(String url, String title);
}
