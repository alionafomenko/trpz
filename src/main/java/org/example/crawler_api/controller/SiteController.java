package org.example.crawler_api.controller;


import org.example.crawler_api.model.Site;
import org.example.crawler_api.repository.DocumentRepository;
import org.example.crawler_api.repository.PictureRepository;
import org.example.crawler_api.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class SiteController {

    @Autowired
    SiteRepository siteRepo;
    DocumentRepository docRepo;
    PictureRepository pictureRepo;

@PostMapping("/addSite")
    public void addSite(@RequestBody Site site){
    siteRepo.save(site);
}

}
