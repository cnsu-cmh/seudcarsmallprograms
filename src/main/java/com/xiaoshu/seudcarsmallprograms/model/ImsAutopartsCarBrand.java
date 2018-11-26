package com.xiaoshu.seudcarsmallprograms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ims_autoparts_car_brand")
public class ImsAutopartsCarBrand extends BaseTransientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer uniacid;

    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 首字母
     */
    private String initials;

    private String name;

    private Boolean status;

    private Integer sort;

    @Column(name = "is_hot")
    private Boolean isHot;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "pic_url")
    private String picUrl;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return uniacid
     */
    public Integer getUniacid() {
        return uniacid;
    }

    /**
     * @param uniacid
     */
    public void setUniacid(Integer uniacid) {
        this.uniacid = uniacid;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取首字母
     *
     * @return initials - 首字母
     */
    public String getInitials() {
        return initials;
    }

    /**
     * 设置首字母
     *
     * @param initials 首字母
     */
    public void setInitials(String initials) {
        this.initials = initials == null ? null : initials.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * @return is_hot
     */
    public Boolean getIsHot() {
        return isHot;
    }

    /**
     * @param isHot
     */
    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return pic_url
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * @param picUrl
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }
}