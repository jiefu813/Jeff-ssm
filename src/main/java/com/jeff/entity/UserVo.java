package com.jeff.entity;

/**
 * @author Jeff
 * @createTime 2019-06-02 15:06
 */
public class UserVo extends User{

    private String createdateStart;
    private String createdateEnd;

    public String getCreatedateStart() {
        return createdateStart;
    }

    public void setCreatedateStart(String createdateStart) {
        this.createdateStart = createdateStart;
    }

    public String getCreatedateEnd() {
        return createdateEnd;
    }

    public void setCreatedateEnd(String createdateEnd) {
        this.createdateEnd = createdateEnd;
    }
}
