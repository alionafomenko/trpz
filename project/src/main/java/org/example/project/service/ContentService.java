package org.example.project.service;

import org.example.project.model.Content;
import org.example.project.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    ContentRepository contentRepository;

    public ContentService() {

    }

    public List<Content> getSearchContent(String searchPhrase) {
        return contentRepository.getSearchContent(searchPhrase);
    }


}
