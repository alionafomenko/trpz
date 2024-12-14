package org.example.project.job;


import org.example.project.composite.URLComposite;
import org.example.project.composite.URLLeaf;
import org.example.project.template.BasicCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParseTask {

    @Autowired
    private BasicCrawler crawler;

    @Scheduled(fixedDelay = 10000)
    public void parseSite() throws Exception {
        System.out.println("parseTask");
        List<org.example.project.model.Document> documentList = crawler.documentService.getAllDocs();
        System.out.println(documentList);


        URLComposite rootComposite = new URLComposite();


        for (org.example.project.model.Document document : documentList) {
            int level = document.getLevel();
            if (level < 5) {
                rootComposite.add(new URLLeaf(document.getUrl(), document.getSiteId(), level + 1, document.getId(), crawler));
            }
        }

        rootComposite.crawl();
    }
}
