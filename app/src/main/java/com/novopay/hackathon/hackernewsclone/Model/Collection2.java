
package com.novopay.hackathon.hackernewsclone.Model;

import com.google.gson.annotations.Expose;

public class Collection2 {

    @Expose
    private Property4 property4;
    @Expose
    private Integer index;
    @Expose
    private String url;

    /**
     * 
     * @return
     *     The property4
     */
    public Property4 getProperty4() {
        return property4;
    }

    /**
     * 
     * @param property4
     *     The property4
     */
    public void setProperty4(Property4 property4) {
        this.property4 = property4;
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
