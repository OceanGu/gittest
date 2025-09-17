package org.example.VO;

import lombok.Data;

import java.util.Date;
@Data
public class PageInfo {
    private Integer hid;

    private String title;

    private Integer type;

    private Integer publisher;

    private Integer pageViews;

    private Integer pastHours;
}
