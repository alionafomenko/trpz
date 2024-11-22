package org.example.project.service;


import org.example.project.job.ParseTask;
import org.example.project.model.Document;
import org.example.project.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService extends ParseTask {

    @Autowired
    DocumentRepository documentRepository;

    public DocumentService() {

    }

    public String addDoc(int siteId, String url, String parentUrl, String status, int level) {
        return documentRepository.addDocument(siteId, url, parentUrl, status, level);
    }

    public List<Document> getAllDocs() {
        return documentRepository.getAllDocs();
    }

    public void saveContent(int docId, String title, String content, String status, int httpStatus) {
        documentRepository.saveContent(docId, title, content, status, httpStatus);
    }


}
