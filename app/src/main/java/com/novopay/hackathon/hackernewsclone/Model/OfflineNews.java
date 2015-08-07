package com.novopay.hackathon.hackernewsclone.Model;

/**
 * Created by abhinava on 7/8/15.
 */
public class OfflineNews {
    private String newsName;
    private String newsUrl;
    private String points;
    private Boolean isFav;

    public OfflineNews(String newsName, String newsUrl, String points, Boolean isFav) {
        this.newsName = newsName;
        this.newsUrl = newsUrl;
        this.points = points;
        this.isFav = isFav;
    }

    public String getNewsName() {

        return newsName;
    }

    public void setNewsName(String newsName) {
        this.newsName = newsName;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public Boolean getIsFav() {
        return isFav;
    }

    public void setIsFav(Boolean isFav) {
        this.isFav = isFav;
    }
}
