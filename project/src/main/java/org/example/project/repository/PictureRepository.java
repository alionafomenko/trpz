package org.example.project.repository;


import org.example.project.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PictureRepository extends JpaRepository<Picture, Long> {

    @Query(value = "SELECT * FROM trpz.add_picture(?1, ?2, ?3)", nativeQuery = true)
    void addPicture(int siteId, String link, String parentUrl);

    @Query(value = "SELECT * FROM trpz.get_site_pictures_1_page(?1, ?2)", nativeQuery = true)
    List<Picture> getPicturesBySiteId(int siteId, int pageNumber);


}
