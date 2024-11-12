package org.example.project.service;


import org.example.project.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    @Autowired
    SiteRepository siteRepository;

    public SiteService(){

    }

}
