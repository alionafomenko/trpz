package org.example.project.controller;




import org.example.project.service.PictureService;
import org.example.project.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/")
public class SiteController {

    @Autowired
    SiteService siteService;
    @Autowired
    PictureService pictureService;



    @GetMapping("/")
    public String mainPage(Model model){

        return "";
    }




}
