package com.jeff.entity;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 菜单类别
	 */
	private String type;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 菜单url
	 */
	private String url;
	/**
	 * 父菜单ID，一级菜单为0
	 */
	private Long parentId;
	/**
	 * 排序
	 */
	private Integer seq;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 是否展开
	 */
	private String opened;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private String createName;
	/**
	 * 修改时间
	 */
	private Date modifyTime;
	/**
	 * 修改人
	 */
	private String modifyName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpened() {
        return opened;
    }

    public void setOpened(String opened) {
        this.opened = opened;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyName() {
        return modifyName;
    }

    public void setModifyName(String modifyName) {
        this.modifyName = modifyName;
    }
}
