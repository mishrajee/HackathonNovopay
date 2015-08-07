
package com.novopay.hackathon.hackernewsclone.Model;

import com.google.gson.annotations.Expose;

public class Collection1 {

    @Expose
    private NewsName newsName;
    @Expose
    private String newsURL;
    @Expose
    private String points;
    @Expose
    private Integer index;
    @Expose
    private String url;

    /**
     * 
     * @return
     *     The newsName
     */
    public NewsName getNewsName() {
        return newsName;
    }

    /**
     * 
     * @param newsName
     *     The newsName
     */
    public void setNewsName(NewsName newsName) {
        this.newsName = newsName;
    }

    /**
     * 
     * @return
     *     The newsURL
     */
    public String getNewsURL() {
        return newsURL;
    }

    /**
     * 
     * @param newsURL
     *     The newsURL
     */
    public void setNewsURL(String newsURL) {
        this.newsURL = newsURL;
    }

    /**
     * 
     * @return
     *     The points
     */
    public String getPoints() {
        return points;
    }

    /**
     * 
     * @param points
     *     The points
     */
    public void setPoints(String points) {
        this.points = points;
    }

    /**
     * 
     * @return
     *     The index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * 
     * @param index
     *     The index
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
