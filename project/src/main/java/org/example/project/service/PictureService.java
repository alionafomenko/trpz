package org.example.project.service;



import org.example.project.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService {

    @Autowired
    PictureRepository pictureRepository;

    public PictureService() {

    }


}
