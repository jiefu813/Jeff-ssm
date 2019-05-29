package com.jeff.common.entity;

import com.jeff.entity.Menu;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jeff
 * @createTime 2019-05-29 22:53
 */
public class Tree implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String text;

    private boolean checked;

    private String state;

    private Long pid;

    private String iconCls;

    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
