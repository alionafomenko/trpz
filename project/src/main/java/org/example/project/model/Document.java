package org.example.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "document", schema = "trpz")
public class Document {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name = "url", length = 1000)
    private  String url;
    @Column(name = "site_id")
    private  Integer siteId;
    @Column(name = "status")
    private  String status;
    @Column(name = "parent_url",  length = 1000)
    private  String parentUrl;
    @Column(name = "html")
    private  String html;
    @Column(name = "insert_date")
    private  Date insertDate;
    @Column(name = "scan_date")
    private  Date scanDate;
    @Column(name = "http_status")
    private  String httpStatus;
    @Column(name = "level")
    private  int level;
    @Column(name = "content",  length = 1000000)
    private  String content;


}
