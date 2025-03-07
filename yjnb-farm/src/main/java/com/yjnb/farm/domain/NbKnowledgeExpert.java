package com.yjnb.farm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yjnb.common.annotation.Excel;
import com.yjnb.common.core.domain.BaseEntity;

/**
 * 知识专家对象 nb_knowledge_expert
 * 
 * @author rob
 * @date 2025-03-06
 */
public class NbKnowledgeExpert extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 专家名称 */
    @Excel(name = "专家名称")
    private String name;

    /** 所属领域 */
    @Excel(name = "所属领域")
    private String fieldCode;

    /** 专家简介 */
    @Excel(name = "专家简介")
    private String description;

    /** 头像图片id */
    @Excel(name = "头像图片id")
    private String image;

    /** 所属机构 */
    @Excel(name = "所属机构")
    private String organization;

    /** 专家等级 */
    @Excel(name = "专家等级")
    private String levelCode;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishTime;

    /** 发布状态：1.已发布；2.未发布 */
    @Excel(name = "发布状态：1.已发布；2.未发布")
    private Long publishStatus;

    /** 是否推荐：1.推荐；2.不推荐 */
    @Excel(name = "是否推荐：1.推荐；2.不推荐")
    private Long recommend;

    /** 浏览数量 */
    @Excel(name = "浏览数量")
    private Long browseNum;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setFieldCode(String fieldCode) 
    {
        this.fieldCode = fieldCode;
    }

    public String getFieldCode() 
    {
        return fieldCode;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }

    public void setOrganization(String organization) 
    {
        this.organization = organization;
    }

    public String getOrganization() 
    {
        return organization;
    }

    public void setLevelCode(String levelCode) 
    {
        this.levelCode = levelCode;
    }

    public String getLevelCode() 
    {
        return levelCode;
    }

    public void setPublishTime(Date publishTime) 
    {
        this.publishTime = publishTime;
    }

    public Date getPublishTime() 
    {
        return publishTime;
    }

    public void setPublishStatus(Long publishStatus) 
    {
        this.publishStatus = publishStatus;
    }

    public Long getPublishStatus() 
    {
        return publishStatus;
    }

    public void setRecommend(Long recommend) 
    {
        this.recommend = recommend;
    }

    public Long getRecommend() 
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
            .append("name", getName())
            .append("fieldCode", getFieldCode())
            .append("description", getDescription())
            .append("image", getImage())
            .append("organization", getOrganization())
            .append("levelCode", getLevelCode())
            .append("publishTime", getPublishTime())
            .append("publishStatus", getPublishStatus())
            .append("recommend", getRecommend())
            .append("browseNum", getBrowseNum())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
