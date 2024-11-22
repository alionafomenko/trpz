package org.example.project.service;



import org.example.project.job.ParseTask;
import org.example.project.model.Picture;
import org.example.project.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService extends ParseTask {

    @Autowired
    PictureRepository pictureRepository;

    public PictureService() {

    }

    public void addPicture(int siteId, String link,  String parentUrl) {
        pictureRepository.addPicture(siteId, link, parentUrl);
    }

    public List<Picture> getPicturesBySiteId(int siteId, int pageNumber) {
        return pictureRepository.getPicturesBySiteId(siteId, pageNumber);
    }


}
