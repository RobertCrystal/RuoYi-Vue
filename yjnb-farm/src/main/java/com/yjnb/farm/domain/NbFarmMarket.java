package com.yjnb.farm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.yjnb.common.annotation.Excel;
import com.yjnb.common.core.domain.BaseEntity;

/**
 * 农贸市场对象 nb_farm_market
 * 
 * @author rob
 * @date 2025-03-06
 */
public class NbFarmMarket extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 市场编号 */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /** 市场名称 */
    @Excel(name = "市场名称")
    private String name;

    /** 所在地区 */
    @Excel(name = "所在地区")
    private String regionId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
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

    public void setRegionId(String regionId) 
    {
        this.regionId = regionId;
    }

    public String getRegionId() 
    {
        return regionId;
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
            .append("regionId", getRegionId())
            .append("createdTime", getCreatedTime())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
