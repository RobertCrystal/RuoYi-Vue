package com.yjnb.farm.service.impl;

import java.util.Date;
import java.util.List;

import com.yjnb.common.utils.UniqueIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yjnb.farm.mapper.NbFarmProduceMapper;
import com.yjnb.farm.domain.NbFarmProduce;
import com.yjnb.farm.service.INbFarmProduceService;

/**
 * 农产品Service业务层处理
 * 
 * @author rob
 * @date 2025-03-06
 */
@Service
public class NbFarmProduceServiceImpl implements INbFarmProduceService 
{
    @Autowired
    private NbFarmProduceMapper nbFarmProduceMapper;

    /**
     * 查询农产品
     * 
     * @param id 农产品主键
     * @return 农产品
     */
    @Override
    public NbFarmProduce selectNbFarmProduceById(Long id)
    {
        return nbFarmProduceMapper.selectNbFarmProduceById(id);
    }

    /**
     * 查询农产品列表
     * 
     * @param nbFarmProduce 农产品
     * @return 农产品
     */
    @Override
    public List<NbFarmProduce> selectNbFarmProduceList(NbFarmProduce nbFarmProduce)
    {
        return nbFarmProduceMapper.selectNbFarmProduceList(nbFarmProduce);
    }

    /**
     * 新增农产品
     * 
     * @param nbFarmProduce 农产品
     * @return 结果
     */
    @Override
    public int insertNbFarmProduce(NbFarmProduce nbFarmProduce)
    {
        nbFarmProduce.setId(UniqueIdGenerator.generateUniqueId());
        nbFarmProduce.setCreatedTime(new Date());
        nbFarmProduce.setPushTime(new Date());
        return nbFarmProduceMapper.insertNbFarmProduce(nbFarmProduce);
    }

    /**
     * 修改农产品
     * 
     * @param nbFarmProduce 农产品
     * @return 结果
     */
    @Override
    public int updateNbFarmProduce(NbFarmProduce nbFarmProduce)
    {
        nbFarmProduce.setUpdatedTime(new Date());
        return nbFarmProduceMapper.updateNbFarmProduce(nbFarmProduce);
    }

    /**
     * 批量删除农产品
     * 
     * @param ids 需要删除的农产品主键
     * @return 结果
     */
    @Override
    public int deleteNbFarmProduceByIds(Long[] ids)
    {
        return nbFarmProduceMapper.deleteNbFarmProduceByIds(ids);
    }

    /**
     * 删除农产品信息
     * 
     * @param id 农产品主键
     * @return 结果
     */
    @Override
    public int deleteNbFarmProduceById(Long id)
    {
        return nbFarmProduceMapper.deleteNbFarmProduceById(id);
    }
}
