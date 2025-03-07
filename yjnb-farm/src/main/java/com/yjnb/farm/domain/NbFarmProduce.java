package com.yjnb.farm.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yjnb.common.annotation.Excel;
import com.yjnb.common.core.domain.BaseEntity;

/**
 * 农产品对象 nb_farm_produce
 * 
 * @author rob
 * @date 2025-03-06
 */
public class NbFarmProduce extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /** 农产品名称 */
    @Excel(name = "农产品名称")
    private String title;

    /** 图片 */
    @Excel(name = "图片")
    private String image;

    /** 卖点摘要 */
    @Excel(name = "卖点摘要")
    private String resume;

    /** 所属品类 */
    private String catgory;

    /** 农产品类型 */
    @Excel(name = "农产品类型")
    private String produceType;

    /** 所属商户 */
    private String providerName;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 上架时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上架时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pushTime;

    /** 上架状态 */
    @Excel(name = "上架状态")
    private String pushStatus;

    /** 是否推荐 */
    @Excel(name = "是否推荐")
    private String recommend;

    /** 产品详情 */
    private String description;

    /** 创建人 */
    @Excel(name = "创建人")
    private String accountId;

    /** 浏览量 */
    @Excel(name = "浏览量")
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

    public void setResume(String resume) 
    {
        this.resume = resume;
    }

    public String getResume() 
    {
        return resume;
    }

    public void setCatgory(String catgory) 
    {
        this.catgory = catgory;
    }

    public String getCatgory() 
    {
        return catgory;
    }

    public void setProduceType(String produceType) 
    {
        this.produceType = produceType;
    }

    public String getProduceType() 
    {
        return produceType;
    }

    public void setProviderName(String providerName) 
    {
        this.providerName = providerName;
    }

    public String getProviderName() 
    {
        return providerName;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setPushTime(Date pushTime) 
    {
        this.pushTime = pushTime;
    }

    public Date getPushTime() 
    {
        return pushTime;
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

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setAccountId(String accountId) 
    {
        this.accountId = accountId;
    }

    public String getAccountId() 
    {
        return accountId;
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
            .append("resume", getResume())
            .append("catgory", getCatgory())
            .append("produceType", getProduceType())
            .append("providerName", getProviderName())
            .append("price", getPrice())
            .append("pushTime", getPushTime())
            .append("pushStatus", getPushStatus())
            .append("recommend", getRecommend())
            .append("description", getDescription())
            .append("accountId", getAccountId())
            .append("browseNum", getBrowseNum())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
