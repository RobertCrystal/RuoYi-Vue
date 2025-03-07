package com.yjnb.farm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yjnb.farm.mapper.NbFarmWorkMapper;
import com.yjnb.farm.domain.NbFarmWork;
import com.yjnb.farm.service.INbFarmWorkService;

/**
 * 农事服务Service业务层处理
 * 
 * @author rob
 * @date 2025-03-06
 */
@Service
public class NbFarmWorkServiceImpl implements INbFarmWorkService 
{
    @Autowired
    private NbFarmWorkMapper nbFarmWorkMapper;

    /**
     * 查询农事服务
     * 
     * @param id 农事服务主键
     * @return 农事服务
     */
    @Override
    public NbFarmWork selectNbFarmWorkById(Long id)
    {
        return nbFarmWorkMapper.selectNbFarmWorkById(id);
    }

    /**
     * 查询农事服务列表
     * 
     * @param nbFarmWork 农事服务
     * @return 农事服务
     */
    @Override
    public List<NbFarmWork> selectNbFarmWorkList(NbFarmWork nbFarmWork)
    {
        return nbFarmWorkMapper.selectNbFarmWorkList(nbFarmWork);
    }

    /**
     * 新增农事服务
     * 
     * @param nbFarmWork 农事服务
     * @return 结果
     */
    @Override
    public int insertNbFarmWork(NbFarmWork nbFarmWork)
    {
        return nbFarmWorkMapper.insertNbFarmWork(nbFarmWork);
    }

    /**
     * 修改农事服务
     * 
     * @param nbFarmWork 农事服务
     * @return 结果
     */
    @Override
    public int updateNbFarmWork(NbFarmWork nbFarmWork)
    {
        return nbFarmWorkMapper.updateNbFarmWork(nbFarmWork);
    }

    /**
     * 批量删除农事服务
     * 
     * @param ids 需要删除的农事服务主键
     * @return 结果
     */
    @Override
    public int deleteNbFarmWorkByIds(Long[] ids)
    {
        return nbFarmWorkMapper.deleteNbFarmWorkByIds(ids);
    }

    /**
     * 删除农事服务信息
     * 
     * @param id 农事服务主键
     * @return 结果
     */
    @Override
    public int deleteNbFarmWorkById(Long id)
    {
        return nbFarmWorkMapper.deleteNbFarmWorkById(id);
    }
}
