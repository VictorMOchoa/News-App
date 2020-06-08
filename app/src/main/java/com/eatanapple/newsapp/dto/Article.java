package com.eatanapple.newsapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {

    private String webUrl;
    private String webTitle;
    private String sectionName;
    private String webPublicationDate;

    public Article() {
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public void setWebPublicationDate(String webPublicationDate) {
        this.webPublicationDate = webPublicationDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "webUrl='" + webUrl + '\'' +
                ", webTitle='" + webTitle + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", publicationDate='" + webPublicationDate + '\'' +
                '}';
    }
}
