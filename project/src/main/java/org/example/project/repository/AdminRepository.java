package org.example.project.repository;

import org.example.project.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(value = "SELECT * FROM trpz.login_admin(?1, ?2)", nativeQuery = true)
    Admin loginAdmin( String login, String password);

    @Query(value = "SELECT * FROM trpz.approve_site(?1, ?2)", nativeQuery = true)
    void approveSite(int adminId, int siteId);

    @Query(value = "SELECT * FROM trpz.reject_site(?1)", nativeQuery = true)
    void rejectSite(int siteId);



}
