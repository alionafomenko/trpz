package org.example.project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "site", schema = "trpz")
public class Site {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "url")
    private  String url;
    @Column(name = "title")
    private  String title;
    @Column(name = "insert_date")
    private  Date insertDate;
    @Column(name = "last_scan_date")
    private  String lastScanDate;
    @Column(name = "document_count")
    private  int documentCount;
    @Column(name = "picture_count")
    private  int pictureCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getLastScanDate() {
        return lastScanDate;
    }

    public void setLastScanDate(String lastScanDate) {
        this.lastScanDate = lastScanDate;
    }

    public int getDocumentCount() {
        return documentCount;
    }

    public void setDocumentCount(int documentCount) {
        this.documentCount = documentCount;
    }

    public int getPictureCount() {
        return pictureCount;
    }

    public void setPictureCount(int pictureCount) {
        this.pictureCount = pictureCount;
    }
}
