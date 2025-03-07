package com.yjnb.farm.service;

import java.util.List;
import com.yjnb.farm.domain.NbFarmWork;

/**
 * 农事服务Service接口
 * 
 * @author rob
 * @date 2025-03-06
 */
public interface INbFarmWorkService 
{
    /**
     * 查询农事服务
     * 
     * @param id 农事服务主键
     * @return 农事服务
     */
    public NbFarmWork selectNbFarmWorkById(Long id);

    /**
     * 查询农事服务列表
     * 
     * @param nbFarmWork 农事服务
     * @return 农事服务集合
     */
    public List<NbFarmWork> selectNbFarmWorkList(NbFarmWork nbFarmWork);

    /**
     * 新增农事服务
     * 
     * @param nbFarmWork 农事服务
     * @return 结果
     */
    public int insertNbFarmWork(NbFarmWork nbFarmWork);

    /**
     * 修改农事服务
     * 
     * @param nbFarmWork 农事服务
     * @return 结果
     */
    public int updateNbFarmWork(NbFarmWork nbFarmWork);

    /**
     * 批量删除农事服务
     * 
     * @param ids 需要删除的农事服务主键集合
     * @return 结果
     */
    public int deleteNbFarmWorkByIds(Long[] ids);

    /**
     * 删除农事服务信息
     * 
     * @param id 农事服务主键
     * @return 结果
     */
    public int deleteNbFarmWorkById(Long id);
}
