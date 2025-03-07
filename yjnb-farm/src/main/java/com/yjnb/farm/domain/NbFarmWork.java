package com.yjnb.farm.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yjnb.common.annotation.Excel;
import com.yjnb.common.core.domain.BaseEntity;

/**
 * 农事服务对象 nb_farm_work
 * 
 * @author rob
 * @date 2025-03-06
 */
public class NbFarmWork extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 图片 */
    @Excel(name = "图片")
    private String image;

    /** 服务价格 */
    @Excel(name = "服务价格")
    private BigDecimal price;

    /** 所属分类 */
    @Excel(name = "所属分类")
    private String catgory;

    /** 摘要 */
    @Excel(name = "摘要")
    private String resume;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 微信号 */
    @Excel(name = "微信号")
    private String weChat;

    /** 服务商名称 */
    @Excel(name = "服务商名称")
    private String providerName;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pubdate;

    /** 发布人 */
    @Excel(name = "发布人")
    private String pubAccountId;

    /** 上架状态：1.已上架；2.未上架 */
    @Excel(name = "上架状态：1.已上架；2.未上架")
    private String pushStatus;

    /** 是否推荐：1.推荐；2.不推荐 */
    @Excel(name = "是否推荐：1.推荐；2.不推荐")
    private String recommend;

    /** 浏览数量 */
    @Excel(name = "浏览数量")
    private Long browseNum;

    /** 创建时间 */
    private Date createdTime;

    /** 更新时间 */
    private Date updatedTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setCatgory(String catgory) 
    {
        this.catgory = catgory;
    }

    public String getCatgory() 
    {
        return catgory;
    }

    public void setResume(String resume) 
    {
        this.resume = resume;
    }

    public String getResume() 
    {
        return resume;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setWeChat(String weChat) 
    {
        this.weChat = weChat;
    }

    public String getWeChat() 
    {
        return weChat;
    }

    public void setProviderName(String providerName) 
    {
        this.providerName = providerName;
    }

    public String getProviderName() 
    {
        return providerName;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setPubdate(Date pubdate) 
    {
        this.pubdate = pubdate;
    }

    public Date getPubdate() 
    {
        return pubdate;
    }

    public void setPubAccountId(String pubAccountId) 
    {
        this.pubAccountId = pubAccountId;
    }

    public String getPubAccountId() 
    {
        return pubAccountId;
    }

    public void setPushStatus(String pushStatus) 
    {
        this.pushStatus = pushStatus;
    }

    public String getPushStatus() 
    {
        return pushStatus;
    }

    public void setRecommend(String recommend) 
    {
        this.recommend = recommend;
    }

    public String getRecommend() 
    {
        return recommend;
    }

    public void setBrowseNum(Long browseNum) 
    {
        this.browseNum = browseNum;
    }

    public Long getBrowseNum() 
    {
        return browseNum;
    }

    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }

    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("image", getImage())
            .append("price", getPrice())
            .append("catgory", getCatgory())
            .append("resume", getResume())
            .append("phone", getPhone())
            .append("weChat", getWeChat())
            .append("providerName", getProviderName())
            .append("description", getDescription())
            .append("pubdate", getPubdate())
            .append("pubAccountId", getPubAccountId())
            .append("pushStatus", getPushStatus())
            .append("recommend", getRecommend())
            .append("browseNum", getBrowseNum())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
