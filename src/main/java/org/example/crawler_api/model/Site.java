package org.example.crawler_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


import java.util.Date;
@Data
@Entity
@Table(name = "site", schema = "trpz")
public class Site {

    @Id
    private  int id;
    private  String url;
    private  String title;
    private  Date insertDate;
    private  Date lastScanDate;
    private  int documentCount;
    private  int pictureCount;


}
