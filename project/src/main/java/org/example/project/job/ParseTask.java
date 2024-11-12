package org.example.project.job;

import org.example.project.service.DocumentService;
import org.example.project.service.PictureService;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

@Component
public class ParseTask {

    @Autowired
    PictureService pictureService;
    @Autowired
    DocumentService documentService;

    @Scheduled(fixedDelay = 10000)
    public void parseSite() {

        List<org.example.project.model.Document> documentList = documentService.getAllDocs();

        for (org.example.project.model.Document document : documentList) {
                int level = document.getLevel();
                if (level < 5) {
                    String url = document.getUrl();
                    try {
                        Document doc = Jsoup.connect(url)
                                .userAgent("AlionaCrawler")
                                .timeout(5000)
                                .followRedirects(true)
                                .referrer("https://google.com")
                                .get();
                        Elements sites = doc.getAllElements();

                        for (Element el : sites) {
                            String tagName = el.tagName();
                            //adding new urls logic

                            //saving images logic

                            //saving content from site
                        }

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        }


    }
}
