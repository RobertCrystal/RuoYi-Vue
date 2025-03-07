package com.yjnb.farm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yjnb.common.annotation.Excel;
import com.yjnb.common.core.domain.BaseEntity;

/**
 * 补贴政策对象 nb_allowance_policy
 * 
 * @author rob
 * @date 2025-03-06
 */
public class NbAllowancePolicy extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 作者/来源 */
    @Excel(name = "作者/来源")
    private String author;

    /** 文章摘要 */
    @Excel(name = "文章摘要")
    private String resume;

    /** 正文内容 */
    @Excel(name = "正文内容")
    private String content;

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

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }

    public void setResume(String resume) 
    {
        this.resume = resume;
    }

    public String getResume() 
    {
        return resume;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
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
            .append("title", getTitle())
            .append("author", getAuthor())
            .append("resume", getResume())
            .append("content", getContent())
            .append("publishTime", getPublishTime())
            .append("publishStatus", getPublishStatus())
            .append("recommend", getRecommend())
            .append("browseNum", getBrowseNum())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
