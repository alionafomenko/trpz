package org.example.project.job;

import org.example.project.ProjectApplication;
import org.example.project.errorHandler.ErrorHandler;
import org.example.project.errorHandler.implError.GenericErrorHandler;
import org.example.project.errorHandler.implError.HttpStatusErrorHandler;
import org.example.project.errorHandler.implError.TimeoutErrorHandler;
import org.example.project.memento.PageCaretaker;
import org.example.project.memento.PageMemento;
import org.example.project.memento.PageState;
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
public class ParseTask extends ProjectApplication {

    @Autowired
    PictureService pictureService;
    @Autowired
    DocumentService documentService;

    @Scheduled(fixedDelay = 10000)
    public void parseSite() {

        List<org.example.project.model.Document> documentList = documentService.getAllDocs();
        PageCaretaker caretaker = new PageCaretaker();

        for (org.example.project.model.Document document : documentList) {
            // System.out.println("Level------- " + document.getLevel());
            int level = document.getLevel();
            if (level < 5) {
                level++;
                String url = document.getUrl();
                System.out.println(url);
                StringBuilder content = new StringBuilder();
                String title = "";
                int httpStatus = 0;

                ErrorHandler handler1 = new HttpStatusErrorHandler();
                ErrorHandler handler2 = new TimeoutErrorHandler();
                ErrorHandler handler3 = new GenericErrorHandler();

                ((HttpStatusErrorHandler) handler1).setNextHandler(handler2);
                ((TimeoutErrorHandler) handler2).setNextHandler(handler3);

                PageState pageState = new PageState();

                try {
                    Document doc = Jsoup.connect(url)
                            .userAgent("AlionaCrawler")
                            .timeout(5000)
                            .followRedirects(true)
                            .referrer("https://google.com")
                            .get();

                    pageState.setState(doc.html(), doc.title());
                    caretaker.save(pageState.saveStateToMemento());


                    Elements sites = doc.getAllElements();
                    httpStatus = doc.connection().response().statusCode();
                    for (Element el : sites) {
                        String tagName = el.tagName();
                        if (tagName.equals("a")) {
                            String link = el.attr("href");
                            if (!link.endsWith(".jpg") && !link.endsWith(".png") && !link.endsWith(".jpeg") && !link.endsWith(".svg")) {
                                if (!link.startsWith("http")) {
                                    if (link.startsWith("/")) {
                                        documentService.addDoc(document.getSiteId() ,link, document.getUrl(), "to_do", level);
                                    }
                                } else {
                                    documentService.addDoc(document.getSiteId() ,link, document.getUrl(), "external_link", 0);
                                }
                            } else {
                                pictureService.addPicture(document.getSiteId(), link, document.getUrl());
                            }
                        } else if (tagName.equals("img")) {
                            String picLink = el.attr("src");
                            pictureService.addPicture(document.getSiteId(), picLink, document.getUrl());
                        } else if (tagName.equals("title")) {
                            title = el.ownText();
                        }

                        String text = el.ownText();
                        if (!text.isEmpty()) {
                            content.append("<p>").append(text).append("</p>\n");

                        }
                    }

                    String finalContent = content.toString();
                    documentService.saveContent(document.getId(), title, finalContent, "scanned", httpStatus);
                    }   catch (Exception e) {
                        handler1.handleError(e);

                        PageMemento savedState = caretaker.undo();
                        if (savedState != null) {
                            pageState.restoreStateFromMemento(savedState);
                            documentService.saveContent(document.getId(), pageState.getTitle(), pageState.getCurrentHtml(), "error_state", httpStatus);
                        }
                    }
                }
        }
    }
}
