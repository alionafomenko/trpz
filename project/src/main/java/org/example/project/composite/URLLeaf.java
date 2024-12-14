package org.example.project.composite;

import org.example.project.template.BasicCrawler;


public class URLLeaf implements CrawlerComponent {
    private final String url;
    private final int siteId;
    private final int level;
    private final int documentId;
    private final BasicCrawler crawler;

    public URLLeaf(String url, int siteId, int level, int documentId, BasicCrawler crawler) {
        this.url = url;
        this.siteId = siteId;
        this.level = level;
        this.documentId = documentId;
        this.crawler = crawler;
    }

    @Override
    public void crawl() throws Exception {
        crawler.crawl(url, siteId, level, documentId);
    }
}

