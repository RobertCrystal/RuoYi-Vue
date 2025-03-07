package com.yjnb.farm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yjnb.common.annotation.Excel;
import com.yjnb.common.core.domain.BaseEntity;

/**
 * 知识课程对象 nb_knowledge_course
 * 
 * @author rob
 * @date 2025-03-06
 */
public class NbKnowledgeCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /** 课程标题 */
    @Excel(name = "课程标题")
    private String title;

    /** 文章摘要 */
    @Excel(name = "文章摘要")
    private String resume;

    /** 专家 */
    @Excel(name = "专家")
    private Long expertId;

    /** 所属领域 */
    @Excel(name = "所属领域")
    private String fieldCode;

    /** 课程封面图片 */
    @Excel(name = "课程封面图片")
    private String image;

    /** 正文 */
    @Excel(name = "正文")
    private String content;

    /** 所属分类 */
    @Excel(name = "所属分类")
    private String serviceCatgoryCode;

    /** 所属品类 */
    @Excel(name = "所属品类")
    private Long produceCategoryId;

    /** 视频文件 */
    @Excel(name = "视频文件")
    private String video;

    /** 课程类型 */
    @Excel(name = "课程类型")
    private String type;

    /** 是否推荐 */
    @Excel(name = "是否推荐")
    private String recommend;

    /** 发布状态  */
    @Excel(name = "发布状态 ")
    private String publishStatus;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishTime;

    /** 浏览数量 */
    @Excel(name = "浏览数量")
    private Long browseNum;

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

    public void setResume(String resume) 
    {
        this.resume = resume;
    }

    public String getResume() 
    {
        return resume;
    }

    public void setExpertId(Long expertId) 
    {
        this.expertId = expertId;
    }

    public Long getExpertId() 
    {
        return expertId;
    }

    public void setFieldCode(String fieldCode) 
    {
        this.fieldCode = fieldCode;
    }

    public String getFieldCode() 
    {
        return fieldCode;
    }

    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setServiceCatgoryCode(String serviceCatgoryCode) 
    {
        this.serviceCatgoryCode = serviceCatgoryCode;
    }

    public String getServiceCatgoryCode() 
    {
        return serviceCatgoryCode;
    }

    public void setProduceCategoryId(Long produceCategoryId) 
    {
        this.produceCategoryId = produceCategoryId;
    }

    public Long getProduceCategoryId() 
    {
        return produceCategoryId;
    }

    public void setVideo(String video) 
    {
        this.video = video;
    }

    public String getVideo() 
    {
        return video;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    public void setRecommend(String recommend) 
    {
        this.recommend = recommend;
    }

    public String getRecommend() 
    {
        return recommend;
    }

    public void setPublishStatus(String publishStatus) 
    {
        this.publishStatus = publishStatus;
    }

    public String getPublishStatus() 
    {
        return publishStatus;
    }

    public void setPublishTime(Date publishTime) 
    {
        this.publishTime = publishTime;
    }

    public Date getPublishTime() 
    {
        return publishTime;
    }

    public void setBrowseNum(Long browseNum) 
    {
        this.browseNum = browseNum;
    }

    public Long getBrowseNum() 
    {
        return browseNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("resume", getResume())
            .append("expertId", getExpertId())
            .append("fieldCode", getFieldCode())
            .append("image", getImage())
            .append("content", getContent())
            .append("serviceCatgoryCode", getServiceCatgoryCode())
            .append("produceCategoryId", getProduceCategoryId())
            .append("video", getVideo())
            .append("type", getType())
            .append("recommend", getRecommend())
            .append("publishStatus", getPublishStatus())
            .append("publishTime", getPublishTime())
            .append("browseNum", getBrowseNum())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
