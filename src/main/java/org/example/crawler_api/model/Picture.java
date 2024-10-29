package org.example.crawler_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "picture", schema = "trpz")
public class Picture {

    @Id
    private  int id;
    private  String url;
    private  int siteId;
    private  String parentUrl;
    private  Date insertDate;

}
