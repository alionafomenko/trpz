package org.example.project.job;

import org.example.project.errorHandler.ErrorHandler;
import org.example.project.errorHandler.implError.GenericErrorHandler;
import org.example.project.errorHandler.implError.HttpStatusErrorHandler;
import org.example.project.errorHandler.implError.TimeoutErrorHandler;
import org.example.project.template.BasicCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParseTask {

    @Autowired
    private BasicCrawler crawler;



    @Scheduled(fixedDelay = 10000)
    public void parseSite() throws Exception {
        List<org.example.project.model.Document> documentList = crawler.documentService.getAllDocs();
        // System.out.println(documentList);
        for (org.example.project.model.Document document : documentList) {
            int level = document.getLevel();
            if (level < 5) {
                crawler.crawl(document.getUrl(), document.getSiteId(), level + 1, document.getId());

            }
        }
    }
}
