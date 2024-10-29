package org.example.crawler_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "document", schema = "trpz")
public class Document {

    @Id
    private  int id;
    private  String url;
    private  int siteId;
    private  String status;
    private  String parentUrl;
    private  String html;
    private  Date insertDate;
    private  Date scanDate;
    private  String httpStatus;
    private  int level;
    private  String content;


}
