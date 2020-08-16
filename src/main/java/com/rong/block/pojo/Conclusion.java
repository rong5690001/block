package com.rong.block.pojo;

import java.util.Date;

public class Conclusion {
    private Integer id;

    private Date date;

    private String diskCore;

    private String review;

    private String tomorrowPlan;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiskCore() {
        return diskCore;
    }

    public void setDiskCore(String diskCore) {
        this.diskCore = diskCore == null ? null : diskCore.trim();
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review == null ? null : review.trim();
    }

    public String getTomorrowPlan() {
        return tomorrowPlan;
    }

    public void setTomorrowPlan(String tomorrowPlan) {
        this.tomorrowPlan = tomorrowPlan == null ? null : tomorrowPlan.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}